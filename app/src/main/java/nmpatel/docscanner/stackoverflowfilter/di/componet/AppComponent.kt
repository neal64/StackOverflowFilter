package nmpatel.docscanner.stackoverflowfilter.di.componet

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import nmpatel.docscanner.stackoverflowfilter.di.MainApplication
import nmpatel.docscanner.stackoverflowfilter.di.module.MainActivityModule
import nmpatel.docscanner.stackoverflowfilter.di.module.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, MainActivityModule::class, ViewModelModule::class])
interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(application: MainApplication)

}