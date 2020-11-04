package com.santiyunikas.mathgeo.model

import com.google.gson.annotations.SerializedName

data class Member(
    @SerializedName("id_member")
    val id_member: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("nama_lengkap")
    val fullname: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("nomor_telepon")
    val phoneNumber: String,
    @SerializedName("active")
    val active:String,
    @SerializedName("otp")
    val otp:String,
    @SerializedName("kode_referal")
    val kode_referal:String,
    @SerializedName("jumlah_koin")
    val jumlah_koin:String
    )