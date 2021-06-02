package com.example.dotainfo.service

import com.example.dotainfo.model.Heroes
import com.example.dotainfo.model.ProPlayer
import retrofit2.http.GET

interface DotaApi {

    @GET("proPlayers/")
    suspend fun getProPlayers() : ArrayList<ProPlayer>

    @GET("heroes/")
    suspend fun getHeroes() : ArrayList<Heroes>

    @GET("heroStats/")
    suspend fun getHeroesStatus() : ArrayList<Heroes>


}