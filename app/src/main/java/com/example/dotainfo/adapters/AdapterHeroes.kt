package com.example.dotainfo.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dotainfo.databinding.RvItemHeroBinding
import com.example.dotainfo.model.Heroes
import java.lang.Exception

class AdapterHeroes(val listaHeroes: List<Heroes>) :
    RecyclerView.Adapter<AdapterHeroes.ViewHolderheroes>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderheroes {
        val binding =  RvItemHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolderheroes(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderheroes, position: Int) {
        holder.onBind(listaHeroes[position], holder)
    }

    override fun getItemCount(): Int = listaHeroes.size

    inner class ViewHolderheroes(val binding: RvItemHeroBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(hero : Heroes, holder : ViewHolderheroes){
            try {
                with(holder){
                    Glide.with(itemView.context).load("http://cdn.dota2.com${hero.img}").into(binding.imageViewHero)
                }
            }catch (Ex : Exception){
             Log.e("fuck", Ex.message ?: "")
            }
        }
    }
}