package com.example.dotainfo.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.dotainfo.customui.FragmentHero

class AdapterViewPager(fragmentManager: FragmentManager, val fragmentList : ArrayList<FragmentHero>)
    : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int = fragmentList.size

    override fun getItem(position: Int): Fragment = fragmentList[position]

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentList[position].getPageTitle()

    }

//    fun addFrag(fragment : Fragment, title : String?){
//        fragmentList.add(fragment)
//
//    }
//
//    fun addFrag(fragment : List<Fragment>){
//        fragmentList.addAll(fragment)
//    }

}