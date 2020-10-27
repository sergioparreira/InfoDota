package com.example.dotainfo.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.Observer
import com.example.dotainfo.MainActivity
import com.example.dotainfo.R
import com.example.dotainfo.repository.DotaRepository
import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.coroutines.CoroutineScope
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult
import org.jetbrains.anko.startActivity
import org.koin.android.ext.android.inject
import org.koin.core.inject

class SplashScreenActivity : AppCompatActivity() {

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

    fun observerCarregamento() {
        mViewModelSplashScreen.finalizouCarregamento.observe(this, Observer {
            if (it)
                abreMenuPrincipal()
        })
    }


    fun carregarDadosDaApi() {
        txtAtualizacaoSplash.setText(getString(R.string.loading_pro_players))
        mViewModelSplashScreen.carregarDadosDaApi()
    }

    fun configuraSplash(){
        Handler().postDelayed({
            carregarDadosDaApi()
        },2000)
    }

    fun abreMenuPrincipal() {
        startActivity<MainActivity>()
        finish()
    }
}