package com.dotahero

import com.dotahero.ui.HomeFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {
    @ContributesAndroidInjector(modules =
    [
        HomeFragmentModule::class
    ]
    )
    fun inject(): MainActivity
}