package com.pra.modernappmvvm.Data.model.user


import com.google.gson.annotations.SerializedName

data class Name(
    @SerializedName("first")
    var first: String,
    @SerializedName("last")
    var last: String,
    @SerializedName("title")
    var title: String
)