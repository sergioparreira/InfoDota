package com.example.dotainfo.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dotainfo.R
import com.example.dotainfo.enums.HeroesEnum
import com.example.dotainfo.model.Heroes
import kotlinx.android.synthetic.main.rv_item_hero.view.*
import java.lang.Exception

class AdapterHeroes(val listaHeroes: List<Heroes>) :
    RecyclerView.Adapter<AdapterHeroes.ViewHolderheroes>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderheroes {
        return ViewHolderheroes(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_item_hero, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolderheroes, position: Int) {
        holder.onBind(listaHeroes[position])
    }

    override fun getItemCount(): Int = listaHeroes.size

    class ViewHolderheroes(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(hero : Heroes){
            with(itemView){
                try {
                    Glide.with(this).load("http://cdn.dota2.com${hero.img}").into(imageViewHero)
                }catch (Ex : Exception){
                 Log.e("fuck", Ex.message ?: "")
                }
            }
        }
    }
}