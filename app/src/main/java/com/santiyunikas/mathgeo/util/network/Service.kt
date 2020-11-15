package com.santiyunikas.mathgeo.util.network

import com.santiyunikas.mathgeo.model.*
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
        @Field("nomor_telepon") numberPhone: String
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

    //untuk get kode referal ada apa nggak
    @GET("/index.php/C_ReferalMember?")
    fun getKodeReferal(
        @Query("kode_referal") kode_referal: String
    ):Call<List<Member>>

    //untuk update jumlah koin
    @FormUrlEncoded
    @PUT("/index.php/C_ReferalMember/")
    fun addNCoin(
        @Field("email") email: String?,
        @Field("jumlah_koin") jumlah_koin: String
    ): Call<Member>

    //tambah kode teman
    @FormUrlEncoded
    @POST("/index.php/C_KodeTeman/")
    fun addKodeTeman(
        @Field("id_member") id_member: String,
        @Field("kode_teman") kode_teman: String
    ): Call<KodeTeman>

    //untuk edit profile
    @FormUrlEncoded
    @PUT("/index.php/C_EditProfile/")
    fun editProfile(
        @Field("id_member") id_member: String?,
        @Field("nama_lengkap") nama_lengkap: String?,
        @Field("nomor_telepon") nomor_telepon: String?,
        @Field("email") email: String?
    ): Call<Member>

    //untuk get detail latihan
    @GET("/index.php/C_DetailLatihan?")
    fun getDetailLatihan(
        @Query("id_latihan") id_latihan: Int
    ):Call<List<DetailLatihan>>

    //untuk get status mengerjakan latihan
    @GET("/index.php/C_StatusMengerjakanLatihan?")
    fun getStatusMengerjakanLatihan(
        @Query("id_latihan") id_latihan: String,
        @Query("id_member") id_member: String
    ):Call<List<StatusMengerjakanLatihan>>

    //tambah status mengerjakan latihan
    @FormUrlEncoded
    @POST("/index.php/C_StatusMengerjakanLatihan/")
    fun addNilaiLatihan(
        @Field("id_member") id_member: String,
        @Field("id_latihan") id_latihan: String,
        @Field("nilai") nilai: String
    ): Call<StatusMengerjakanLatihan>

    //ubah nilai
    @FormUrlEncoded
    @PUT("/index.php/C_StatusMengerjakanLatihan/")
    fun updateNilaiLatihan(
        @Field("id_member") id_member: String?,
        @Field("id_latihan") id_latihan: String?,
        @Field("nilai") nilai: String?
    ): Call<StatusMengerjakanLatihan>

    //untuk get detail quiz
    @GET("/index.php/C_DetailQuiz?")
    fun getDetailQuiz(
        @Query("id_quiz") id_quiz: Int
    ):Call<List<DetailQuiz>>

    //untuk get status mengerjakan quiz
    @GET("/index.php/C_StatusMengerjakanQuiz?")
    fun getStatusMengerjakanQuiz(
        @Query("id_quiz") id_quiz: String,
        @Query("id_member") id_member: String
    ):Call<List<StatusMengerjakanQuiz>>

    //tambah status mengerjakan quiz
    @FormUrlEncoded
    @POST("/index.php/C_StatusMengerjakanQuiz/")
    fun addNilaiQuiz(
        @Field("id_member") id_member: String,
        @Field("id_quiz") id_quiz: String,
        @Field("nilai") nilai: String
    ): Call<StatusMengerjakanQuiz>

    //ubah nilai quiz
    @FormUrlEncoded
    @PUT("/index.php/C_StatusMengerjakanQuiz/")
    fun updateNilaiQuiz(
        @Field("id_member") id_member: String?,
        @Field("id_quiz") id_latihan: String?,
        @Field("nilai") nilai: String?
    ): Call<StatusMengerjakanQuiz>
}