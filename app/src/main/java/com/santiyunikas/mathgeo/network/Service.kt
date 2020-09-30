package com.santiyunikas.mathgeo.network

import com.santiyunikas.mathgeo.model.Member
import retrofit2.Call
import retrofit2.http.*

interface Service {
    //untuk register
    @FormUrlEncoded
    @POST("member")
    fun register(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("nama_lengkap") fullname: String,
        @Field("nomor_telepon") numberPhone: String
    ): Call<Member>

    //untuk login
    @GET("/index.php/C_Login?")
    fun login(
        @Query("email") email: String
    ):Call<List<Member>>
}