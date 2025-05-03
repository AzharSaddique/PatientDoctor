package com.mtbc.mvvmwithflow.di

import com.mtbc.mvvmwithflow.network.ApiAServiceImpl
import com.mtbc.mvvmwithflow.network.ApiInterfaces
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesUrl() = "http://172.16.0.65:3030/api/"

    @Provides
    @Singleton
    @Named("mainRetrofit")
    fun provideRetrofit(url: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    @Named("mainRetrofit")
    fun provideApiInterfaces(@Named("mainRetrofit") retrofit: Retrofit): ApiInterfaces =
        retrofit.create(ApiInterfaces::class.java)

    @Provides
    @Singleton
    fun provideApiAServiceImpl(@Named("mainRetrofit") apiInterfaces: ApiInterfaces): ApiAServiceImpl =
        ApiAServiceImpl(apiInterfaces)
}