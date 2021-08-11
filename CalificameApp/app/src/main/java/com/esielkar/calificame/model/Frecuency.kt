package com.esielkar.calificame.model

enum class Frecuency {
    ALWAYS {
        override fun getValue() = 100.0
    },
    SOMETIMES {
        override fun getValue() = 50.0
    },
    NEVER {
        override fun getValue() = 0.0
    };

    abstract fun getValue() : Double
}