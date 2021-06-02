package com.example.dotainfo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.lifecycle.Observer
import com.example.dotainfo.MainActivity
import com.example.dotainfo.R
import com.example.dotainfo.interfaces.ISincronizacao
import com.example.dotainfo.repository.DotaRepository
import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.coroutines.CoroutineScope
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject
import org.koin.core.inject

class SplashScreenActivity : AppCompatActivity(), ISincronizacao {

    private val mViewModelSplashScreen: ViewModelSplashScreen by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }

    override fun onResume() {
        super.onResume()
        observerCarregamento()
        configuraSplash()
    }

    private fun observerCarregamento() {
        mViewModelSplashScreen.finalizouCarregamento.observe(this, Observer {
            if (it)
                abrirMenuPrincipal()
        })
    }

    private fun carregarDados() {
        try{
            sendProgressSincMsg("Loading pro players")
            mViewModelSplashScreen.carregarDadosProPlayers()
            sendProgressSincMsg("Loading heroes")
            mViewModelSplashScreen.carregarDadosHeroes()
        }catch (ex : Exception){
            Log.e("CARREGDADOS", ex.message ?: "")
            sendProgressSincMsg("An error ocurred while loading pro players")

        }
    }

    fun configuraSplash(){
        Handler().postDelayed({
            carregarDados()
        },2000)
    }

    private fun abrirMenuPrincipal() {
        startActivity<MainActivity>()
        finish()
    }


    override fun sendProgressSincMsg(msg: String) {
        txtAtualizacaoSplash.text = msg
    }
}