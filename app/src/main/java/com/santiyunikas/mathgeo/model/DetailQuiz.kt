package com.santiyunikas.mathgeo.model

import com.google.gson.annotations.SerializedName


data class DetailQuiz(
    @SerializedName("id_soal")
    val id_soal: String,
    @SerializedName("id_quiz")
    val id_quiz: String,
    @SerializedName("soal")
    val soal: String,
    @SerializedName("kunci")
    val kunci: String,
    @SerializedName("pilihan_ganda")
    val pilihan_ganda: String,
    @SerializedName("gambar")
    val gambar: String
)