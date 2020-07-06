package com.dotahero.repository

import com.dotahero.model.Hero
import com.dotahero.model.HeroStats
import retrofit2.http.GET

interface DotaApi{
    @GET("/api/heroes")
    suspend fun getHeroes() : List<Hero>

    @GET("/api/heroStats")
    suspend fun getHeroStats(): List<HeroStats>
}