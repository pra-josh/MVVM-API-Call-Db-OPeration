package com.pra.modernappmvvm.Data.model.user


import com.google.gson.annotations.SerializedName

data class RandomUserApiResponse(
    @SerializedName("results")
    var users: List<User>
)