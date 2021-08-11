package com.esielkar.calificame.model

enum class Score {
    EXCELLENT {
        override fun getValue() = 100.0
    }, GOOD {
        override fun getValue() = 80.0
    }, REGULAR {
        override fun getValue() = 60.0
    }, BAD {
        override fun getValue() = 40.0
    }, TERRIBLE {
        override fun getValue() = 20.0
    };
    abstract fun getValue() : Double
}