package com.master_details_view_api_filter.base.di
import com.master_details_view_api_filter.base.api.meal_api.MealApiImpl
import com.master_details_view_api_filter.base.api.meal_api.MealApiRepository
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
    fun provideMealsRepository(mealrepoImpl: MealApiImpl): MealApiRepository = mealrepoImpl

}
