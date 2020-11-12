package nmpatel.docscanner.stackoverflowfilter.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.question_list_items.view.*
import nmpatel.docscanner.stackoverflowfilter.R
import nmpatel.docscanner.stackoverflowfilter.model.Item

class MyAdapter(var questionList: ArrayList<Item>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.question_list_items, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(questionList[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item) {
            itemView.apply {
                txtViewQuesTitle.text = item.title
                txtViewAnswerCounts.text = context.getString(R.string.str_answers_count, item.answerCount.toString())
                txtViewViewCount.text = context.getString(R.string.str_view_count, item.viewCount.toString())
            }
        }
    }

    fun retrieveData(item: ArrayList<Item>) {
        questionList.apply {
            clear()
            questionList = item
            notifyDataSetChanged()
        }
    }

    fun clearData() {
        questionList.clear()
        notifyDataSetChanged()
    }
}