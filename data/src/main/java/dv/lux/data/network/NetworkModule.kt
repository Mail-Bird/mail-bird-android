package dv.lux.data.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dv.lux.data.BuildConfig
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

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @OkHttpClientAuthOutlook
    fun providesOkHttpClientAuthOutlook(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @OkHttpClientMicrosoftGraph
    fun providesOkHttpClientMicrosoftGraph(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @RetrofitAuthOutlook
    fun provideRetrofitAuthOutlook(@OkHttpClientAuthOutlook okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.OUTLOOK_DOMAIN_AUTH)
            .client(okHttpClient)
            .build()

    @Provides
    @RetrofitMicrosoftGraph
    fun provideRetrofitMicrosoftGraph(@OkHttpClientMicrosoftGraph okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.OUTLOOK_DOMAIN_GRAPH)
            .client(okHttpClient)
            .build()

    @Provides
    fun provideApiAuthOutlookService(@RetrofitAuthOutlook retrofit: Retrofit): AuthOutlookService =
        retrofit.create(AuthOutlookService::class.java)

    @Provides
    fun provideMicrosoftGraphService(@RetrofitMicrosoftGraph retrofit: Retrofit): MicrosoftGraphService =
        retrofit.create(MicrosoftGraphService::class.java)
}