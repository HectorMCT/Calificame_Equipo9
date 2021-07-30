package com.esielkar.calificame.model.adapter

internal sealed interface Bindable<E> {
    fun bind(item : E)
}