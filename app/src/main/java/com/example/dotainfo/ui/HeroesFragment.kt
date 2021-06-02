package com.example.dotainfo.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.dotainfo.adapters.AdapterHeroes
import com.example.dotainfo.adapters.AdapterProPlayers
import com.example.dotainfo.customui.FragmentHero
import com.example.dotainfo.databinding.HeroesFragmentBinding
import com.example.dotainfo.enums.HeroesEnum
import com.example.dotainfo.interfaces.IFragmentTable
import org.koin.android.ext.android.inject

class HeroesFragment(private val enumHeroes: HeroesEnum, title : String) : FragmentHero(title), IFragmentTable {

    private lateinit var recycleView: RecyclerView

    private val heroesFragmentviewModel : HeroesViewModel by inject()
    private lateinit var heroesFragmentBinding : HeroesFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        heroesFragmentBinding = HeroesFragmentBinding.inflate(layoutInflater)
        return heroesFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        configureObserverProPlayer()
        configuraRecyclerView()
        carregarProPlayers()
    }

    private fun carregarProPlayers() {
        heroesFragmentviewModel.loadHeroes(enumHeroes.name)
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
                2,
                androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
            )
            recycleView.layoutManager = layoutManager
        }

    }


}