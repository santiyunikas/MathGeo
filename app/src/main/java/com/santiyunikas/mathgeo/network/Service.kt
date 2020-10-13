package com.santiyunikas.mathgeo.network

import com.santiyunikas.mathgeo.model.MemberModel
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
    ): Call<MemberModel>

    //untuk login
    @GET("/index.php/C_Login?")
    fun login(
        @Query("email") email: String
    ):Call<List<MemberModel>>

    //untuk reset password
    @FormUrlEncoded
    @PUT("/index.php/C_Login/")
    open fun resetPassword(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<MemberModel>
}