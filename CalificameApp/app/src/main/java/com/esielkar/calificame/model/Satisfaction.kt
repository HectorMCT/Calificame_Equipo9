package com.esielkar.calificame.model

enum class Satisfaction {
    SATISFIED {
        override fun getValue() = 100.0
    },
    HALF_SATISFIED {
        override fun getValue() = 50.0
    },
    DISSATISFIED {
        override fun getValue() = 0.0
    };
    abstract fun getValue() : Double
}