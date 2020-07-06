package com.dotahero.repository.repo

import com.dotahero.model.Hero
import com.dotahero.model.HeroStats

interface DotaRepository {
    suspend fun getHero():List<Hero>
    suspend fun getHeroStats():List<HeroStats>
}