package com.husein.digitalent.moviee

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var poster: Int,
    var title: String,
    var description: String,
    var language: String,
    var runtime: String,
    var genres: String
) : Parcelable