package com.esielkar.calificame.model

enum class YesNo {
    YES {
        override fun getValue() = 100.0
    },
    NO {
        override fun getValue() = 0.0
    };
    abstract fun getValue() : Double
}