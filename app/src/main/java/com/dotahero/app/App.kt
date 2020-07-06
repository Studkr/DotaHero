package com.dotahero.app

import androidx.databinding.library.BuildConfig
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.EpoxyController
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


open class App : DaggerApplication() {

    open val component: AndroidInjector<DaggerApplication> by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .appModule(AppModule(this))
            .build()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = component

    override fun onCreate() {
        super.onCreate()

        val handler = EpoxyAsyncUtil.getAsyncBackgroundHandler()
        EpoxyController.defaultDiffingHandler = handler
        EpoxyController.defaultModelBuildingHandler = handler

    }


}