package com.example.dotainfo.ui.heroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dotainfo.R
import com.example.dotainfo.adapters.AdapterViewPager
import com.example.dotainfo.customui.FragmentHero
import com.example.dotainfo.enums.HeroesEnum
import com.example.dotainfo.ui.HeroesFragmentAttry
import kotlinx.android.synthetic.main.fragment_heroes.*

class HeroesFragment : Fragment() {

    private lateinit var heroesViewModel: HeroesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        heroesViewModel =
            ViewModelProvider(this).get(HeroesViewModel::class.java)
        return inflater.inflate(R.layout.fragment_heroes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = viewpager
        val tabletLayout = tablayout

        tabletLayout.setupWithViewPager(viewPager)

        val fragment1 = HeroesFragmentAttry(HeroesEnum.STR, "Strength")
        val fragment2 = HeroesFragmentAttry(HeroesEnum.AGI,"Agility")
        val fragment3 = HeroesFragmentAttry(HeroesEnum.INT,"Inteligency")

        val listaFragment : ArrayList<FragmentHero> = arrayListOf(fragment1, fragment2, fragment3)

        val viewPagerAdapter = AdapterViewPager(childFragmentManager, listaFragment)

        viewPager.adapter = viewPagerAdapter
    }
}