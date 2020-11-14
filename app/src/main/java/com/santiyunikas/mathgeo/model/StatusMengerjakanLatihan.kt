package com.santiyunikas.mathgeo.model

import com.google.gson.annotations.SerializedName

data class StatusMengerjakanLatihan(
    @SerializedName("id_mengerjakan_latihan")
    val id_mengerjakan_latihan: String,
    @SerializedName("id_latihan")
    val id_latihan: String,
    @SerializedName("id_member")
    val id_member: String,
    @SerializedName("status_pengerjaan")
    val status_pengerjaan: String,
    @SerializedName("nilai")
    val nilai: String
)