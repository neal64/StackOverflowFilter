package nmpatel.docscanner.stackoverflowfilter.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import nmpatel.docscanner.stackoverflowfilter.R
import nmpatel.docscanner.stackoverflowfilter.model.Item
import nmpatel.docscanner.stackoverflowfilter.model.networkLayer.Results
import nmpatel.docscanner.stackoverflowfilter.view.adapter.MyAdapter
import nmpatel.docscanner.stackoverflowfilter.viewmodel.MainActivityViewModel
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var mainActivityViewModel : MainActivityViewModel
    lateinit var mAdapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)

        mAdapter = MyAdapter(arrayListOf())
        recycleView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = mAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    swipeRefresh.isEnabled =
                        (layoutManager as LinearLayoutManager).findFirstCompletelyVisibleItemPosition() == 0
                }
            })
        }

        getObservedData()
        swipeRefresh.apply {
            mAdapter.clearData()
            setOnRefreshListener {
                isRefreshing = true
                getObservedData()
            }
        }
    }

    private fun getObservedData() {
        mainActivityViewModel.getCurrentQuestionDataData().observe(this, Observer {
            it?.let { result ->
                when (result) {
                    is Results.Success -> {
                        showListUI()
                        refreshList(result.data.items)
                        swipeRefresh.isRefreshing = false
                    }
                    is Results.Error -> {
                        error_Description.text = result.exception.toString()
                        onError()
                    }
                    is Results.Loading -> {
                        if (!swipeRefresh.isRefreshing()) {
                            progressBar.visibility = View.VISIBLE
                        }
                    }
                }
            }
        })
    }

    private fun onError() {
        error_Description.visibility = View.VISIBLE
        swipeRefresh.isRefreshing = false
        recycleView.visibility = View.GONE
        progressBar.visibility = View.GONE
    }

    private fun showListUI() {
        recycleView.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
        error_Description.visibility = View.GONE
    }

    private fun refreshList(items: ArrayList<Item>) {
        mAdapter.apply {
            retrieveData(items)
        }
    }
}