package com.dotahero.repository.repo

import com.dotahero.model.Hero
import com.dotahero.model.HeroStats
import com.dotahero.repository.DotaApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DotaRepositoryImpl @Inject constructor(
    private val dotaApi: DotaApi
) :DotaRepository{
    override suspend fun getHero(): List<Hero> = withContext(Dispatchers.IO){
        dotaApi.getHeroes()
    }

    override suspend fun getHeroStats(): List<HeroStats> = withContext(Dispatchers.IO) {
      dotaApi.getHeroStats()
    }

}