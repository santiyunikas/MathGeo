package com.santiyunikas.mathgeo.util.network

import com.santiyunikas.mathgeo.model.Member
import retrofit2.Call
import retrofit2.http.*

interface Service {
    //untuk register
    @FormUrlEncoded
    @POST("/index.php/C_Register/")
    fun register(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("nama_lengkap") fullname: String,
        @Field("nomor_telepon") numberPhone: String,
        @Field("active") active: Int
    ): Call<Member>

    //untuk login
    @GET("/index.php/C_Login?")
    fun login(
        @Query("email") email: String
    ):Call<List<Member>>

    @GET("/index.php/C_ResetPassword?")
    fun sendOtp(
        @Query("email") email: String
    ):Call<List<Member>>

    //untuk reset password
    @FormUrlEncoded
    @PUT("/index.php/C_ResetPassword/")
    fun resetPassword(
        @Field("email") email: String?,
        @Field("password") password: String
    ): Call<Member>
}