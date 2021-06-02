package com.example.dotainfo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.lifecycle.Observer
import com.example.dotainfo.MainActivity
import com.example.dotainfo.R
import com.example.dotainfo.interfaces.ISincronizacao
import kotlinx.android.synthetic.main.activity_splash_screen.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SplashScreenActivity : AppCompatActivity(), ISincronizacao, KoinComponent {

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
        val intent = Intent(this, MainActivity::class.java)
        this.startActivity(intent)
        finish()
    }


    override fun sendProgressSincMsg(msg: String) {
        txtAtualizacaoSplash.text = msg
    }
}