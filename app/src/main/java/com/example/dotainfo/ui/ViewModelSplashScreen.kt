package com.example.dotainfo.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dotainfo.database.OpenDataBase
import com.example.dotainfo.repository.DotaRepository
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.lang.Exception

class ViewModelSplashScreen : ViewModel(), KoinComponent {

    private val mDotaRepository: DotaRepository by inject()
    private val mDataBase: OpenDataBase by inject()

    private val _finalizouCarregamento = MutableLiveData<Boolean>()
    val finalizouCarregamento: LiveData<Boolean> = _finalizouCarregamento

    fun carregarDadosProPlayers() {
        viewModelScope.launch {
            try {
                if (!playersJaCarregado()) {
                    mDataBase.ProPlayer().insertProPlayers(mDotaRepository.getProPlayers())
                }
            } catch (e: Exception) {
            }
        }
    }

    fun carregarDadosHeroes() {
        viewModelScope.launch {
            try {
                if (!playersJaCarregado()) {
                    mDataBase.Heroes().insertHeroes(mDotaRepository.getHeroes())
                }
                finalizouCarregamento()
            } catch (e: Exception) {
                finalizouCarregamento()
            }
        }
    }

    private fun finalizouCarregamento(){
        _finalizouCarregamento.value = true
    }

    suspend fun playersJaCarregado(): Boolean {
        return mDataBase.ProPlayer().getProPlayers().isNotEmpty()

    }
}