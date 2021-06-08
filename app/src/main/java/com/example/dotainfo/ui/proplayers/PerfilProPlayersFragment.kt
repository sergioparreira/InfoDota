package com.example.dotainfo.ui.proplayers

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.dotainfo.R
import com.example.dotainfo.databinding.DetalheProPlayersFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent

class PerfilProPlayersFragment : Fragment(), KoinComponent {

    private val viewModel: DetalheProPlayersViewModel by inject()
    val args : PerfilProPlayersFragmentArgs by navArgs()
    private lateinit var detalheProPlayersFragmentBinding : DetalheProPlayersFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detalheProPlayersFragmentBinding = DetalheProPlayersFragmentBinding.inflate(layoutInflater)
        return detalheProPlayersFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webViewSettings =  detalheProPlayersFragmentBinding.webViewProfile.settings

        detalheProPlayersFragmentBinding.webViewProfile.loadUrl(args.urlProfile)

    }

    private fun configureWebView(){
        with(detalheProPlayersFragmentBinding){
            val webViewSettings =  webViewProfile.settings
            webViewSettings.javaScriptEnabled = true
            webViewProfile.loadUrl(args.urlProfile)
            webViewProfile.webViewClient = WebViewClient()
        }

    }


}