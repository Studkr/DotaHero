package com.dotahero.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.dotahero.R
import com.dotahero.ui.MainHero
import com.dotahero.utils.BaseEpoxyHolder
import com.flipsidegroup.nmt.system.loadImageCrop

@EpoxyModelClass(
    layout = R.layout.item_hero_view
)
abstract class HeroModel : EpoxyModelWithHolder<HeroModel.Holder>() {

    @EpoxyAttribute
    lateinit var model : MainHero

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var cardClickListener: View.OnClickListener? = null


    override fun bind(holder: Holder) {
        with(holder) {
            card.setOnClickListener(cardClickListener)
            heroImage.loadImageCrop(model.image)
            heroName.text = model.name
        }

    }

    override fun unbind(holder: Holder) {
        with(holder) {
            card.setOnClickListener(null)
        }

    }


    class Holder : BaseEpoxyHolder() {
        val card: View by bind(R.id.heroCard)
        val heroName: TextView by bind(R.id.heroName)
        val heroImage: ImageView by bind(R.id.heroImage)
    }
}