package com.seminario.moviecatalog.di

import com.seminario.moviecatalog.data.remote.api.TmdbApi
import com.seminario.moviecatalog.data.repository.MovieRepositoryImpl
import com.seminario.moviecatalog.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(api: TmdbApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }

}