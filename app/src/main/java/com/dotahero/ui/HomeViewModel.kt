package com.dotahero.ui

import androidx.lifecycle.*
import com.dotahero.model.Hero
import com.dotahero.model.HeroStats
import com.dotahero.repository.repo.DotaRepository
import com.dotahero.rest.BASE_URL
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
        private val dotaRepository: DotaRepository
) : ViewModel() {

    val heroList = MutableStateFlow<List<Hero>>(emptyList())
    val heroStats = MutableStateFlow<List<HeroStats>>(emptyList())
    val cardClicked = LiveEvent<MainHero>()

    init {
        viewModelScope.launch {
            heroList.value = dotaRepository.getHero()
            heroStats.value = dotaRepository.getHeroStats()
        }


    }
    val fullHero = heroList.combine(heroStats) { hero, stats ->
        if(hero.isNotEmpty() && stats.isNotEmpty()) {
            hero.mapIndexed { index, hero ->
                MainHero(
                    id = hero.id,
                    name = stats[index].localizedName,
                    image = BASE_URL + stats[index].img,
                    primaryAttr = hero.primaryAttr
                )
            }
        }else{
            emptyList()
        }

    }.asLiveData()

    fun cardClicked(it: MainHero) {
        cardClicked.value = it
    }
}

data class MainHero(
    val id:Int,
    val image :String,
    val name : String,
    val primaryAttr :String
)