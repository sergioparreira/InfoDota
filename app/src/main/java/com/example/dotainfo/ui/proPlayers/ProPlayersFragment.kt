package com.example.dotainfo.ui.proPlayers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.dotainfo.adapters.AdapterProPlayers
import com.example.dotainfo.databinding.FragmentProPlayersBinding
import org.koin.android.ext.android.inject

class ProPlayersFragment : Fragment() {

	private val proPlayersViewModel: ProPlayersViewModel by inject()
	private lateinit var recycleView: RecyclerView
	private lateinit var fragmentProPlayersBinding: FragmentProPlayersBinding

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		fragmentProPlayersBinding = FragmentProPlayersBinding.inflate(layoutInflater)
		return  fragmentProPlayersBinding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		configuraRecyclerView()
		configureObserverProPlayer()
		carregarProPlayers()
	}

	private fun configuraRecyclerView() {
		with(fragmentProPlayersBinding){
			recycleView = proPlayersRecyclerView
			val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
			recycleView.layoutManager = layoutManager
		}

	}

	private fun carregarProPlayers() {
		proPlayersViewModel.getProPlayers()
	}

	private fun configureObserverProPlayer() {
		proPlayersViewModel.proPlayers.observe(viewLifecycleOwner, Observer {
			recycleView.adapter = AdapterProPlayers(it)
		})
	}
}