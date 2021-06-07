package com.example.dotainfo.ui.heroes

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.example.dotainfo.R
import com.example.dotainfo.adapters.AdapterHeroes
import com.example.dotainfo.customui.FragmentHero
import com.example.dotainfo.databinding.FragmentHeroesAttryBinding
import com.example.dotainfo.enums.HeroesEnum
import com.example.dotainfo.interfaces.IFragmentTable
import org.koin.android.ext.android.inject

class HeroesFragment : Fragment() {

    private lateinit var recycleView: RecyclerView

    private val heroesFragmentviewModel: HeroesViewModel by inject()
    private lateinit var heroesFragmentBinding: FragmentHeroesAttryBinding


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
        onClickButtonscomplexity()
    }

    private fun onClickButtonsattributes() {
        heroesFragmentBinding.complexity1.setOnClickListener { complecity1 ->
            onChooseComplexity(complecity1.id)
        }
        heroesFragmentBinding.complexity2.setOnClickListener { complecity2 ->
            onChooseComplexity(complecity2.id)
        }
        heroesFragmentBinding.complexity3.setOnClickListener { complecity3 ->
            onChooseComplexity(complecity3.id)
        }

    }

    private fun onClickButtonscomplexity() {
        heroesFragmentBinding.complexity1.setOnClickListener { complecity1 ->
            onChooseComplexity(complecity1.id)
        }
        heroesFragmentBinding.complexity2.setOnClickListener { complecity2 ->
            onChooseComplexity(complecity2.id)
        }
        heroesFragmentBinding.complexity3.setOnClickListener { complecity3 ->
            onChooseComplexity(complecity3.id)
        }

    }

    private fun onChooseComplexity(id: Int){
        when(id){
            heroesFragmentBinding.complexity1.id ->{
                with(heroesFragmentBinding){
                    complexity1.isSelected = if(complexity2.isSelected || complexity3.isSelected) true else !complexity1.isSelected
                    complexity2.isSelected = false
                    complexity3.isSelected = false
                }
            }
            heroesFragmentBinding.complexity2.id ->{
                with(heroesFragmentBinding){
                    complexity1.isSelected = true
                    complexity2.isSelected = true
                    complexity3.isSelected = false
                }
            }
            heroesFragmentBinding.complexity3.id ->{
                with(heroesFragmentBinding){
                    complexity1.isSelected = true
                    complexity2.isSelected = true
                    complexity3.isSelected = true
                }
            }
        }
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
        with(heroesFragmentBinding) {
            recycleView = heroesRecyclerView
            val layoutManager = androidx.recyclerview.widget.StaggeredGridLayoutManager(
                3,
                androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
            )
            recycleView.layoutManager = layoutManager
        }
    }


}