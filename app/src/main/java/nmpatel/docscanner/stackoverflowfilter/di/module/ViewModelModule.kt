package nmpatel.docscanner.stackoverflowfilter.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import nmpatel.docscanner.stackoverflowfilter.di.ViewModelKey
import nmpatel.docscanner.stackoverflowfilter.viewmodel.MainActivityViewModel
import nmpatel.docscanner.stackoverflowfilter.viewmodel.ViewModelFactory

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}