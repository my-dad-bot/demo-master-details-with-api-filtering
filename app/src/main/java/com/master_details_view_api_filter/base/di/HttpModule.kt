package com.master_details_view_api_filter.base.di

import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.master_details_view_api_filter.base.api.meal_api.MealApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HttpModule {

    private const val base_url = "https://www.themealdb.com/api/json/v1/1/"

    @Provides
    @Singleton
    fun provideHttpCache(@ApplicationContext application: Context): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(@ApplicationContext context: Context, cache: Cache): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS)
            .addNetworkInterceptor(loggingInterceptor)



        return okHttpClient.cache(cache)
            .build()

    }


    @Singleton
    @Provides
    fun provideClient(
        gson: Gson,
        @ApplicationContext context: Context,
        cache: Cache
    ): MealApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(base_url)
            .client(provideOkHttpClient(context, cache))
            .build().create(MealApiService::class.java)
    }
/*
    private fun okhttpClientWithOAuth(
        okHttpClient: OkHttpClient,
        appPreference: AppPreference
    ): OkHttpClient {
        return okHttpClient.newBuilder()
            .addInterceptor(
                OAuthInterceptor(
                    appPreference
                )
            ).authenticator(RefreshTokenInterceptor(okHttpClient,appPreference)).build()
    }*/
}