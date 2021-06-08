package com.example.dotainfo.ui.proplayers

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.example.dotainfo.databinding.PerfilProPlayersFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent

class PerfilProPlayersFragment : Fragment(), KoinComponent {

    private val viewModel: DetalheProPlayersViewModel by inject()
    val args : PerfilProPlayersFragmentArgs by navArgs()
    private lateinit var perfilProPlayersFragmentBinding : PerfilProPlayersFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        perfilProPlayersFragmentBinding = PerfilProPlayersFragmentBinding.inflate(layoutInflater)
        return perfilProPlayersFragmentBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuringWebView()
    }

    private fun configuringWebView(){
        with(perfilProPlayersFragmentBinding){
            val webViewSettings =  webViewProfile.settings
            webViewSettings.javaScriptEnabled = true
            webViewProfile.loadUrl(args.urlProfile)
            webViewProfile.webViewClient = WebViewClient()
        }
    }



}