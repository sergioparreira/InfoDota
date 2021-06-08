package com.example.dotainfo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "heroes")
data class Heroes(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("primary_attr")
    val primaryAttr: String,
    @SerializedName("attack_type")
    val attackType: String,
//    @SerializedName("id")
//    val roles: List<String>,
    @SerializedName("legs")
    val legs: Int,
    @SerializedName("img")
    val img: String


)