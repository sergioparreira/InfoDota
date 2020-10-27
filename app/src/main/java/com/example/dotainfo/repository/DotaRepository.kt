package com.example.dotainfo.repository

import com.example.dotainfo.database.OpenDataBase
import com.example.dotainfo.model.ProPlayer
import com.example.dotainfo.service.DotaApi

interface DotaRepository {

    suspend fun getProPlayers() : ArrayList<ProPlayer>

    suspend fun getProPlayersFromBd() : List<ProPlayer>

}


class DotaRepositoryImpl(private val mDotaApi: DotaApi, private val mDotaBd : OpenDataBase) : DotaRepository{

    override suspend fun getProPlayers(): ArrayList<ProPlayer> {
       return mDotaApi.getProPlayers()
    }

    override suspend fun getProPlayersFromBd(): List<ProPlayer> {
        return mDotaBd.ProPlayer().getProPlayers()
    }

}