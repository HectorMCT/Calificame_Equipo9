package com.esielkar.calificame.api



object ApiUtils {
    private val baseUrl = "https://f1yi66cpk3.execute-api.us-east-1.amazonaws.com"

    val api: ApiService
        get() = RetrofitClient.getClient(baseUrl)!!.create(
            ApiService::class.java
        )


}