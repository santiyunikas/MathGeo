package com.santiyunikas.mathgeo.network

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

    //untuk koneksi ke C_Member.php
    private fun registerMember(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://mathgeo.ub-learningtechnology.com/index.php/C_Register/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun serviceRegisterMember() = registerMember().create(Service::class.java)!!

    //untuk koneksi ke C_Member.php
    private fun loginMember(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://mathgeo.ub-learningtechnology.com/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun serviceLoginMember() = loginMember().create(Service::class.java)!!
}