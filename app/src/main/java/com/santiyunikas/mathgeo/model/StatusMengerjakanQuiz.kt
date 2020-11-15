package com.santiyunikas.mathgeo.model

import com.google.gson.annotations.SerializedName

data class StatusMengerjakanQuiz(
    @SerializedName("id_mengerjakan_quiz")
    val id_mengerjakan_quiz: String,
    @SerializedName("id_quiz")
    val id_quiz: String,
    @SerializedName("id_member")
    val id_member: String,
    @SerializedName("status_pengerjaan")
    val status_pengerjaan: String,
    @SerializedName("nilai")
    val nilai: String
)