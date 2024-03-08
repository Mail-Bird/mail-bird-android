package dv.lux.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dv.lux.data.annotation.OkHttpClientAuthOutlook
import dv.lux.data.annotation.OkHttpClientMicrosoftGraph
import dv.lux.data.annotation.RetrofitAuthOutlook
import dv.lux.data.annotation.RetrofitMicrosoftGraph
import dv.lux.data.api.AuthOutlookService
import dv.lux.data.api.MicrosoftGraphService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    @OkHttpClientAuthOutlook
    fun providesOkHttpClientAuthOutlook(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    @OkHttpClientMicrosoftGraph
    fun providesOkHttpClientMicrosoftGraph(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Singleton
    @Provides
    @RetrofitAuthOutlook
    fun provideRetrofitAuthOutlook(@OkHttpClientAuthOutlook okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.AUTH_OUTLOOK_DOMAIN)
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    @RetrofitMicrosoftGraph
    fun provideRetrofitMicrosoftGraph(@OkHttpClientMicrosoftGraph okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.MICROSOFT_GRAPH_API_DOMAIN)
            .client(okHttpClient)
            .build()

    @Singleton
    @Provides
    fun provideApiAuthOutlookService(@RetrofitAuthOutlook retrofit: Retrofit): AuthOutlookService =
        retrofit.create(AuthOutlookService::class.java)

    @Singleton
    @Provides
    fun provideMicrosoftGraphService(@RetrofitMicrosoftGraph retrofit: Retrofit): MicrosoftGraphService =
        retrofit.create(MicrosoftGraphService::class.java)
}