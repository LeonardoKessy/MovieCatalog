package com.seminario.moviecatalog.di

import com.seminario.moviecatalog.BuildConfig
import com.seminario.moviecatalog.data.remote.api.TmdbApi
import com.seminario.moviecatalog.data.remote.api.TmdbApiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import java.util.Locale
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            // Auth
            .addInterceptor { chain ->
                val originalRequest = chain.request()

                val language = Locale.getDefault().language

                val newUrl = originalRequest.url.newBuilder()
                    .addQueryParameter("language", language)
                    .build()

                val newRequest = originalRequest.newBuilder()
                    .url(newUrl)
                    .addHeader("Authorization", "Bearer ${BuildConfig.TMDB_API_KEY}")
                    .addHeader("accept", "application/json")
                    .build()

                chain.proceed(newRequest)
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val json = Json { ignoreUnknownKeys = true }

        return Retrofit.Builder()
            .baseUrl(TmdbApiConstants.API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Provides
    @Singleton
    fun provideTmdbApi(retrofit: Retrofit): TmdbApi {
        return retrofit.create(TmdbApi::class.java)
    }

}