package com.esielkar.calificame.api



object ApiUtils {
    val baseUrl = "https://f1yi66cpk3.execute-api.us-east-1.amazonaws.com"
    private val _ApiService  = RetrofitClient.getClient(baseUrl)!!.create(ApiService::class.java)

    val api: ApiService
        get() = _ApiService


}