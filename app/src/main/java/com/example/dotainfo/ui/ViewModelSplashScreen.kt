package com.example.dotainfo.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dotainfo.database.OpenDataBase
import com.example.dotainfo.repository.DotaRepository
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.lang.Exception

class ViewModelSplashScreen : ViewModel(), KoinComponent {

    private val mDotaRepository: DotaRepository by inject()
    private val mDataBase: OpenDataBase by inject()

    private val _finalizouCarregamento = MutableLiveData<Boolean>()
    val finalizouCarregamento: LiveData<Boolean> = _finalizouCarregamento

    fun carregarDadosDaApi() {

        viewModelScope.launch {
            try {
                if (!jaFoiCarregado()) {
                    mDataBase.ProPlayer().insertProPlayers(mDotaRepository.getProPlayers())
                    _finalizouCarregamento.value = true
                }
                _finalizouCarregamento.value = true
            } catch (e: Exception) {
                _finalizouCarregamento.value = true;
                Log.e("ERRO", e.message.toString())
            }
        }
    }

    suspend fun jaFoiCarregado(): Boolean {
        return mDataBase.ProPlayer().getProPlayers().size > 0

    }
}