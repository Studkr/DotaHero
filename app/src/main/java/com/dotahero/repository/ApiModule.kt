package com.dotahero.repository

import com.dotahero.rest.RetrofitModule
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module(
    includes = [
        RetrofitModule::class
    ]
)
class ApiModule {
    @Provides
    fun provideContentApi(retrofit: Retrofit) = retrofit.create(DotaApi::class.java)
}