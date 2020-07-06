package com.dotahero.app

import android.app.Application
import android.content.Context
import com.dotahero.MainActivityModule
import com.dotahero.repository.RepositoryModule
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Named
import javax.inject.Singleton

@Module(
    includes = [
        MainActivityModule::class,
        RepositoryModule::class
    ]
)
class AppModule(val app: Application) {

    @Provides
    fun context(): Context = app

}

@Module
class CoroutineContextModule {
    @Provides
    @Singleton
    @Named("ROH_USE_CASE")
    fun providesCoroutineContext() = Job() + Dispatchers.Default
}
