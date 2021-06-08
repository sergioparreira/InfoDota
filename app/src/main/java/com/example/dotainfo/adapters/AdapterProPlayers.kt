package com.example.dotainfo.adapters

import android.content.Context
import android.graphics.Paint
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
import com.example.dotainfo.databinding.RvItemProPlayerBinding
import com.example.dotainfo.interfaces.IProPlayers
import com.example.dotainfo.model.ProPlayer

class AdapterProPlayers(val listaProPlayers: List<ProPlayer>, val context: Context, val iProPlayers: IProPlayers) :
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
            holder.bindView(it, holder, context, iProPlayers)
        }
    }

    class ViewHolderProPlayers(val binding: RvItemProPlayerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(mProPlayer: ProPlayer, holder: ViewHolderProPlayers, context: Context, iProPlayers: IProPlayers) {
            with(holder) {
                Glide.with(itemView.context).load("${mProPlayer.avatarmedium}").into(binding.imgViewProPlayer)
                binding.txtViewNameProPlayer.text = context.getString(R.string.name_proplayer, mProPlayer.name)
                binding.txtViewProfileURL.text = context.getString(R.string.name_profile_url, mProPlayer.profileurl)
                binding.txtViewProfileURL.paintFlags = Paint.UNDERLINE_TEXT_FLAG
                binding.txtViewProfileURL.setOnClickListener {
                    iProPlayers.carregarProfile(mProPlayer.profileurl)
                }
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