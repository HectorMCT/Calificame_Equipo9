package com.esielkar.calificame.api

import com.esielkar.calificame.objects.UniResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/production/prueba-images-bedu?tenant_id=sprmx")
    fun getUni(): Call<UniResponse>
}