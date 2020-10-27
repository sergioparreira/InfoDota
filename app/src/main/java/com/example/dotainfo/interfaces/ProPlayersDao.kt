package com.example.dotainfo.interfaces

import androidx.room.*
import com.example.dotainfo.model.ProPlayer

@Dao
interface ProPlayersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProPlayers(proPlayers : List<ProPlayer>)


    @Query("select * from pro_players")
    suspend fun getProPlayers() : List<ProPlayer>

}