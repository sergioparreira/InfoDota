package com.example.dotainfo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.AutoTransition
import androidx.transition.TransitionManager
import com.bumptech.glide.Glide
import com.example.dotainfo.databinding.RvItemProPlayerBinding
import com.example.dotainfo.model.ProPlayer

class AdapterProPlayers(val listaProPlayers: List<ProPlayer>) :
    RecyclerView.Adapter<AdapterProPlayers.ViewHolderProPlayers>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProPlayers {
        val binding = RvItemProPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolderProPlayers(binding)
    }

    override fun getItemCount(): Int {
        return listaProPlayers.size
    }

    override fun onBindViewHolder(holder: ViewHolderProPlayers, position: Int) {
        listaProPlayers.get(position).let {
            holder.bindView(it, holder)
        }
    }

    class ViewHolderProPlayers(val binding: RvItemProPlayerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(mProPlayer: ProPlayer, holder: ViewHolderProPlayers) {
            with(holder) {
                Glide.with(itemView.context).load("${mProPlayer.avatarmedium}").into(binding.imgViewProPlayer)
                binding.txtViewNameProPlayer.text = "Name: ${mProPlayer.name.toString()}"
                binding.txtViewPersonNameProPlayer.text = mProPlayer.personaname.toString()
                binding.txtViewTeamNameProPlayer.text = mProPlayer.team_name.toString()
                binding.showButton.setOnClickListener {
                    showOrRide(binding.card, binding.textViewToExpandle, View.VISIBLE)
                }
                binding.hideButton.setOnClickListener {
                    showOrRide(binding.card, binding.textViewToExpandle, View.GONE)
                }
            }
        }

        fun showOrRide(cardView: CardView, textView: TextView, visibilidade: Int) {
            TransitionManager.beginDelayedTransition(cardView, AutoTransition())
            textView.visibility = visibilidade

        }
    }

}