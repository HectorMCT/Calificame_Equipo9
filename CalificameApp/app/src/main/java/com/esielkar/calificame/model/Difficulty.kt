package com.esielkar.calificame.model

enum class Difficulty {

    VERY_EASY{ override fun getValue() = 20.0 },
    EASY{ override fun getValue() = 40.0},
    REGULAR{ override fun getValue() = 60.0 },
    HARD{ override fun getValue() = 80.0 },
    VERY_HARD{ override fun getValue() = 100.0 };

    abstract fun getValue() : Double


}