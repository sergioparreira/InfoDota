package com.example.dotainfo.ui.heroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.dotainfo.adapters.AdapterHeroes
import com.example.dotainfo.customui.FragmentHero
import com.example.dotainfo.databinding.FragmentHeroesAttryBinding
import com.example.dotainfo.enums.HeroesEnum
import com.example.dotainfo.interfaces.IFragmentTable
import org.koin.android.ext.android.inject

class HeroesFragment() : Fragment(){

    private lateinit var recycleView: RecyclerView

    private val heroesFragmentviewModel : HeroesViewModel by inject()
    private lateinit var heroesFragmentBinding : FragmentHeroesAttryBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        heroesFragmentBinding = FragmentHeroesAttryBinding.inflate(layoutInflater)
        return heroesFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureObserverProPlayer()
        configuraRecyclerView()
        carregarHeroes()
    }

    private fun carregarHeroes() {
       heroesFragmentviewModel.loadHeroes(null)
    }

    private fun configureObserverProPlayer() {
        heroesFragmentviewModel._heroes.observe(viewLifecycleOwner, Observer {
            recycleView.adapter = AdapterHeroes(it)
        })
    }


    private fun configuraRecyclerView() {
        with(heroesFragmentBinding){
            recycleView = heroesRecyclerView
            val layoutManager = androidx.recyclerview.widget.StaggeredGridLayoutManager(
                3,
                androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
            )
            recycleView.layoutManager = layoutManager
        }
    }


}