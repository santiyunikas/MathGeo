package com.santiyunikas.mathgeo.model

import com.google.gson.annotations.SerializedName

data class KodeTeman(
    @SerializedName("id_member")
    val id_member: String,
    @SerializedName("id_referal")
    val id_referal: String,
    @SerializedName("kode_teman")
    val kode_teman: String
)