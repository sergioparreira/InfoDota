package com.example.dotainfo.ui.proPlayers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.dotainfo.R
import com.example.dotainfo.adapters.AdapterProPlayers
import com.example.dotainfo.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_gallery.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ProPlayersFragment : Fragment() {

    private val proPlayersViewModel: ProPlayersViewModel by inject()
    private lateinit var recycleView : RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    //    proPlayersViewModel = ViewModelProvider(this).get(ProPlayersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configuraRecyclerView()
        configureObserverProPlayer()
        carregarProPlayers()
    }

    fun configuraRecyclerView(){
        recycleView = proPlayersRecyclerView
        val layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        recycleView.layoutManager = layoutManager
    }

    fun carregarProPlayers() {
        proPlayersViewModel.getProPlayers()
    }

    fun configureObserverProPlayer() {
        proPlayersViewModel.proPlayers.observe(viewLifecycleOwner, Observer {
            recycleView.adapter = AdapterProPlayers(it)
        })
    }


}