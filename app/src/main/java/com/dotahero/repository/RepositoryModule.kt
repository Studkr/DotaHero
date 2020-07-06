package com.dotahero.repository

import com.dotahero.repository.repo.DotaRepository
import com.dotahero.repository.repo.DotaRepositoryImpl
import dagger.Module
import dagger.Provides

@Module(includes = [ApiModule::class])
class RepositoryModule {
    @Provides
    fun providerDotaRepo(impl: DotaRepositoryImpl): DotaRepository = impl
}