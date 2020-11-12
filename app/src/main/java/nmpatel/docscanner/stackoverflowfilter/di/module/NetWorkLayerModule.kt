package nmpatel.docscanner.stackoverflowfilter.di.module

import dagger.Module
import dagger.Provides
import nmpatel.docscanner.stackoverflowfilter.AppConstant
import nmpatel.docscanner.stackoverflowfilter.BuildConfig
import nmpatel.docscanner.stackoverflowfilter.model.networkLayer.QuestionListService
import nmpatel.docscanner.stackoverflowfilter.model.networkLayer.repository.QuestionListRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetWorkLayerModule {

    @Provides
    fun provideQUestionListRepository(): QuestionListRepository {
        return QuestionListRepository()
    }

    @Singleton
    @Provides
    fun providesHttpInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }
        return httpLoggingInterceptor
    }

    @Singleton
    @Provides
    fun provideOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.networkInterceptors().add(httpLoggingInterceptor)
        okHttpClient.readTimeout(2, TimeUnit.MINUTES)
        okHttpClient.connectTimeout(2, TimeUnit.MINUTES)
        return okHttpClient.build()
    }

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(AppConstant.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideQuestionListService(retrofit: Retrofit): QuestionListService {
        return retrofit.create(QuestionListService::class.java)
    }
}