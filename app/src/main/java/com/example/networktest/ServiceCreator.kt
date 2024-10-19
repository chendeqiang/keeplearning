package com.example.networktest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

/**
 * Created by deqiangchen on 2024/10/18.
 */
object ServiceCreator {

    private const val BASE_URL="http://10.0.2.2/"

    private val  retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass:Class<T>):T = retrofit.create(serviceClass)

    inline fun <reified T>create():T= create(T::class.java)

}