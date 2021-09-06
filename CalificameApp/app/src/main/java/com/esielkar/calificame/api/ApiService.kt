package com.esielkar.calificame.api

import com.esielkar.calificame.objects.UniResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface ApiService {
    @GET("/production/prueba-images-bedu?tenant_id=sprmx")
    fun getUni(): Flowable<UniResponse>
}