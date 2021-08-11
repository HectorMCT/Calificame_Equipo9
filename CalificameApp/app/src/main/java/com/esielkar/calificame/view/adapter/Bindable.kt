package com.esielkar.calificame.view.adapter

internal sealed interface Bindable<E> {
    fun bind(item : E)
}