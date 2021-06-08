package com.example.dotainfo.ui.proplayers

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dotainfo.R

class DetalheProPlayersFragment : Fragment() {

    companion object {
        fun newInstance() = DetalheProPlayersFragment()
    }

    private lateinit var viewModel: DetalheProPlayersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detalhe_pro_players_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetalheProPlayersViewModel::class.java)


    }

}