package com.example.dotainfo.customui

import androidx.fragment.app.Fragment
import com.example.dotainfo.interfaces.IFragmentTable

open class FragmentHero(val title: String): Fragment(), IFragmentTable {
    override fun getPageTitle(): String {
        return title
    }
}