package com.santiyunikas.mathgeo.model

import com.google.gson.annotations.SerializedName

data class PembahasanLatihan(
    @SerializedName("id_pembahasan")
    val id_pembahasan: String,
    @SerializedName("id_soal")
    val id_soal: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("gambar")
    val gambar: String
)