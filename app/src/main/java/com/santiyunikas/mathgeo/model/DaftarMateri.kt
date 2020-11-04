package com.santiyunikas.mathgeo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DaftarMateri(
    var title: String,
    var desc: String
) : Parcelable