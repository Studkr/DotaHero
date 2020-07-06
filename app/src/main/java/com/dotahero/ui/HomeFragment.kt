package com.dotahero.ui


import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.dotahero.R
import com.dotahero.app.viewmodel.ViewModelFactory
import com.dotahero.ui.adapter.HeroController
import com.dotahero.utils.BaseDaggerFragment
import com.github.ajalt.timberkt.Timber
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.home_fragment.*
import pro.shineapp.rentout.system.ext.observe
import javax.inject.Inject

class HomeFragment : BaseDaggerFragment(R.layout.home_fragment) {

    companion object {
        fun newInstance() = HomeFragment()
    }

    @Inject
    lateinit var factory: ViewModelFactory
    private val viewModel: HomeViewModel by viewModels { factory }

    private val controller = HeroController{
            viewModel.cardClicked(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        heroView.adapter = controller.adapter
        heroView.addItemDecoration(RecyclerViewItemDecoration(6))
        heroView.layoutManager = GridLayoutManager(context, 2)

        observe(viewModel.fullHero){
            progressBar.isVisible = it.isEmpty()
            controller.setData(it)
        }

        observe(viewModel.cardClicked){
           
        }
    }

}