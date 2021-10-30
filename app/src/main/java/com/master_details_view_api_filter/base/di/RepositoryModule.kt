package com.master_details_view_api_filter.base.di
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

//    @Provides
//    @Singleton
//    fun provideRidesRepository(ridesPIImpl: RidesApiImpl): RidesRepository = ridesAPIImpl

}
