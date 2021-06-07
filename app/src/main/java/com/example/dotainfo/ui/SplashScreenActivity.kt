package com.example.dotainfo.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.dotainfo.MainActivity
import com.example.dotainfo.R
import com.example.dotainfo.databinding.ActivitySplashScreenBinding
import com.example.dotainfo.interfaces.ISincronizacao
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent

class SplashScreenActivity : AppCompatActivity(), ISincronizacao, KoinComponent {

    private val mViewModelSplashScreen: ViewModelSplashScreen by inject()
    private lateinit var mSplashScreenBinding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mSplashScreenBinding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(mSplashScreenBinding.root)

        Glide.with(this)
            .load(R.drawable.dotagif)
            .into(mSplashScreenBinding.imageViewSplashScreen)

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
        },8000)
    }

    private fun abrirMenuPrincipal() {
        val intent = Intent(this, MainActivity::class.java)
        this.startActivity(intent)
        finish()
    }


    override fun sendProgressSincMsg(msg: String) {
        mSplashScreenBinding.txtAtualizacaoSplash.text = msg
    }
}