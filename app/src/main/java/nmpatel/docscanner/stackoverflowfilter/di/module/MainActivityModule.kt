package nmpatel.docscanner.stackoverflowfilter.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector

import nmpatel.docscanner.stackoverflowfilter.view.MainActivity

@Module (includes = [NetWorkLayerModule::class])
abstract class MainActivityModule {

   @ContributesAndroidInjector()
   abstract fun mainActivity() : MainActivity

}