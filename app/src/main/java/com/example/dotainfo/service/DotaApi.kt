package com.example.dotainfo.service

import com.example.dotainfo.model.ProPlayer
import retrofit2.http.GET

interface DotaApi {

    @GET("proPlayers/")
    suspend fun getProPlayers() : ArrayList<ProPlayer>

}