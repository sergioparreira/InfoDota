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
import com.example.dotainfo.R
import com.example.dotainfo.model.ProPlayer
import kotlinx.android.synthetic.main.rv_item_pro_player.view.*

class AdapterProPlayers(val listaProPlayers: List<ProPlayer>) :
    RecyclerView.Adapter<AdapterProPlayers.ViewHolderProPlayers>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProPlayers {
        return ViewHolderProPlayers(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_item_pro_player, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listaProPlayers.size
    }

    override fun onBindViewHolder(holder: ViewHolderProPlayers, position: Int) {
        listaProPlayers.get(position).let {
            holder.bindView(it)
        }
    }

    class ViewHolderProPlayers(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(mProPlayer: ProPlayer) {
            with(itemView) {
                Glide.with(this).load("${mProPlayer.avatarmedium}").into(imgViewProPlayer)
                txtViewNameProPlayer.text = "Name: ${mProPlayer.name.toString()}"
                txtViewPersonNameProPlayer.text = mProPlayer.personaname.toString()
                txtViewTeamNameProPlayer.text = mProPlayer.team_name.toString()
                showButton.setOnClickListener {
                    showOrRide(card, textViewToExpandle, View.VISIBLE)
                }
                hideButton.setOnClickListener {
                    showOrRide(card, textViewToExpandle, View.GONE)
                }
            }
        }

        fun showOrRide(cardView: CardView, textView: TextView, visibilidade: Int) {
            TransitionManager.beginDelayedTransition(cardView, AutoTransition())
            textView.visibility = visibilidade

        }
    }

}