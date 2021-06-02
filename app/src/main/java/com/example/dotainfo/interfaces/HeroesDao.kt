package com.example.dotainfo.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dotainfo.enums.HeroesEnum
import com.example.dotainfo.model.Heroes

@Dao
interface HeroesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHeroes(proPlayers : List<Heroes>)


    @Query("select * from heroes")
    suspend fun getHeroes() : List<Heroes>

    @Query("select * from heroes where primaryAttr = :enumHero")
    suspend fun getHeroesAttry(enumHero: String) : List<Heroes>

}