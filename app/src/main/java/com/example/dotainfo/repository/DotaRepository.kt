package com.example.dotainfo.repository

import com.example.dotainfo.database.OpenDataBase
import com.example.dotainfo.enums.HeroesEnum
import com.example.dotainfo.model.Heroes
import com.example.dotainfo.model.ProPlayer
import com.example.dotainfo.service.DotaApi
import java.util.*
import kotlin.collections.ArrayList

interface DotaRepository {

    suspend fun getProPlayers() : ArrayList<ProPlayer>

    suspend fun getProPlayersFromBd() : List<ProPlayer>

    suspend fun getHeroes() : List<Heroes>

    suspend fun getHeroesFromBd() : List<Heroes>

    suspend fun getHeroesBdAttry(enumHeroes: String): List<Heroes>?
}


class DotaRepositoryImpl(private val mDotaApi: DotaApi, private val mDotaBd : OpenDataBase) : DotaRepository{

    override suspend fun getProPlayers(): ArrayList<ProPlayer> {
       return mDotaApi.getProPlayers()
    }

    override suspend fun getProPlayersFromBd(): List<ProPlayer> {
        return mDotaBd.ProPlayer().getProPlayers()
    }

    override suspend fun getHeroes(): List<Heroes> {
        return mDotaApi.getHeroesStatus()
    }

    override suspend fun getHeroesFromBd(): List<Heroes> {
        return mDotaBd.Heroes().getHeroes()
    }

    override suspend fun getHeroesBdAttry(enumHeroes: String): List<Heroes> {
        return when (enumHeroes) {
            HeroesEnum.ALL.name.toLowerCase(Locale.getDefault()) -> mDotaBd.Heroes().getHeroes()
            else ->  mDotaBd.Heroes().getHeroesAttry(enumHeroes)
        }

    }


}