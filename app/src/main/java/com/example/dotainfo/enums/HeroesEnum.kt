package com.example.dotainfo.enums

import com.facebook.stetho.json.annotation.JsonValue

enum class HeroesEnum {
    STR {
        fun getCompleteName() = "STRENGTH"
    },
    AGI {
        fun getCompleteName() = "AGILITY"
    },
    INT {
        fun getCompleteName() = "INTELIGENCY"
    }
}