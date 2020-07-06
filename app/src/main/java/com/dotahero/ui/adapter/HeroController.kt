package com.dotahero.ui.adapter

import com.airbnb.epoxy.TypedEpoxyController
import com.dotahero.ui.MainHero

class HeroController (
    val onCardClick: (model: MainHero) -> Unit) : TypedEpoxyController<List<MainHero>>() {

    override fun buildModels(data: List<MainHero>) {
        data.forEach {
            hero {
                id("${it.id}")
                model(it)
                cardClickListener{model, parentView, clickedView, position ->
                   onCardClick(model.model())
                }

            }
        }
    }

}