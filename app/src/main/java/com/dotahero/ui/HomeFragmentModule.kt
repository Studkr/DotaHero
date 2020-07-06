package com.dotahero.ui

import androidx.lifecycle.ViewModel
import com.dotahero.app.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface HomeFragmentModule {
    @ContributesAndroidInjector
    fun inject(): HomeFragment

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun inject(viewModel: HomeViewModel): ViewModel
}