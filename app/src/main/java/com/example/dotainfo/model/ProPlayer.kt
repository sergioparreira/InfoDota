package com.example.dotainfo.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "pro_players")
data class ProPlayer(
    @PrimaryKey(autoGenerate = false)
    val account_id: Long,
    val steamid: String? = "",
    val avatar: String?= "",
    val avatarmedium: String?= "",
    val avatarfull: String?= "",
    val profileurl: String?= "",
    val personaname: String?= "",
    val last_login: String?= "",
    val full_history_time: String?= "",
    val cheese: String?= "",
    val fh_unavailable: Boolean? = false,
    val loccountrycode: String?= "",
    val last_match_timeval: String?= "",
    val plus: Boolean? = false,
    val name: String?= "",
    val country_code: String?= "",
    val fantasy_role: Int?= null,
    val team_id: Long? = null,
    val team_name: String?= "",
    val team_tag: String?= "",
    val is_locked: Boolean? = false,
    val is_pro: Boolean? = false,
    val locked_until: String?
)