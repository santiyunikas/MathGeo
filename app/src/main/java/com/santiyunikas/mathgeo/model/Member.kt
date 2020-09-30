package com.santiyunikas.mathgeo.model

import com.google.gson.annotations.SerializedName

data class Member(
    @SerializedName("email")
    val email: String,
    @SerializedName("nama_lengkap")
    val fullname: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("nomor_telepon")
    val phoneNumber: String
)