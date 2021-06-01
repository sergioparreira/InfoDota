package com.example.dotainfo.ui.proPlayers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.dotainfo.R
import com.example.dotainfo.adapters.AdapterProPlayers
import com.example.dotainfo.databinding.FragmentGalleryBinding
import kotlinx.android.synthetic.main.fragment_gallery.*
import org.koin.android.ext.android.inject

class ProPlayersFragment : Fragment() {

	private val proPlayersViewModel: ProPlayersViewModel by inject()
	private lateinit var recycleView: RecyclerView
	private lateinit var fragmentGalleryBinding: FragmentGalleryBinding

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		fragmentGalleryBinding = FragmentGalleryBinding.inflate(layoutInflater)
		return  fragmentGalleryBinding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		configuraRecyclerView()
		configureObserverProPlayer()
		carregarProPlayers()
	}

	fun configuraRecyclerView() {
		with(fragmentGalleryBinding){
			recycleView = proPlayersRecyclerView
			val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
			recycleView.layoutManager = layoutManager
		}

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