package nmpatel.docscanner.stackoverflowfilter.di


import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import nmpatel.docscanner.stackoverflowfilter.di.componet.DaggerAppComponent

class MainApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

}