package com.santiyunikas.mathgeo.util.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NetworkConfig {
    //untuk logging
    private fun getInterceptor(): OkHttpClient{
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()
    }
    var gson = GsonBuilder()
        .setLenient()
        .create()!!

    //untuk koneksi ke server
    private fun connection(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://mathgeo.ub-learningtechnology.com/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun serviceConnection() = connection().create(Service::class.java)!!
}