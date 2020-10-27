package com.example.dotainfo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dotainfo.interfaces.ProPlayersDao
import com.example.dotainfo.model.ProPlayer

@Database(entities = [ProPlayer::class], version = 1)
abstract class OpenDataBase : RoomDatabase() {

    abstract fun ProPlayer(): ProPlayersDao


}