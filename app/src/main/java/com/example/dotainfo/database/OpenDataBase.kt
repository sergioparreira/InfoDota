package com.example.dotainfo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dotainfo.interfaces.HeroesDao
import com.example.dotainfo.interfaces.ProPlayersDao
import com.example.dotainfo.model.Heroes
import com.example.dotainfo.model.ProPlayer

@Database(entities = [ProPlayer::class, Heroes::class],  version = 1)
abstract class OpenDataBase : RoomDatabase() {

    abstract fun ProPlayer(): ProPlayersDao

    abstract fun Heroes(): HeroesDao


}