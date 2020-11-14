package com.santiyunikas.mathgeo.model

import com.google.gson.annotations.SerializedName

data class DetailLatihan(
    @SerializedName("id_soal")
    val id_soal: String,
    @SerializedName("id_latihan")
    val id_latihan: String,
    @SerializedName("soal")
    val soal: String,
    @SerializedName("kunci")
    val kunci: String,
    @SerializedName("pilihan_ganda")
    val pilihan_ganda: String,
    @SerializedName("gambar")
    val gambar: String
)