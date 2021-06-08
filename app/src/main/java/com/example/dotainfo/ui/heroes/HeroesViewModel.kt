package com.example.dotainfo.ui.heroes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dotainfo.enums.HeroesEnum
import com.example.dotainfo.model.Heroes
import com.example.dotainfo.repository.DotaRepository
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.*

class HeroesViewModel : ViewModel(), KoinComponent {

    private val mDotaRepository: DotaRepository by inject()

    var _heroes = MutableLiveData<List<Heroes>>()
    private val heroes = _heroes

    var _onError = MutableLiveData<Boolean>()
    private val onError = _onError

    var _onFinisih = MutableLiveData<Boolean>()
    private val onFinisih = _onFinisih

    fun loadHeroes(attribute: String) {
        try {
            viewModelScope.launch {
                when(attribute){
                    HeroesEnum.ALL.name -> _heroes.value = mDotaRepository.getHeroesFromBd()
                    else -> _heroes.value = mDotaRepository.getHeroesBdAttry(attribute.lowercase())
                }
            }
        } catch (ex: Exception) {
        }
    }


}