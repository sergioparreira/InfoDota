package com.example.dotainfo.ui.proPlayers

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dotainfo.model.ProPlayer
import com.example.dotainfo.repository.DotaRepository
import com.example.dotainfo.repository.DotaRepositoryImpl
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.lang.Exception

class ProPlayersViewModel() : ViewModel(), KoinComponent {

    private val _proPlayers = MutableLiveData<List<ProPlayer>>()
    val proPlayers: LiveData<List<ProPlayer>> = _proPlayers
    private val mDotaRepository: DotaRepository by inject()

    fun getProPlayers() {
        try {
            viewModelScope.launch {
                _proPlayers.value = mDotaRepository.getProPlayersFromBd();
            }
        } catch (e: Exception) {
            Log.e("erro na requisição", e.message.toString())
        }
    }

}