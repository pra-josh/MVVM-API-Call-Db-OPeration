package com.pra.modernappmvvm.Data.api

import android.content.Context
import com.pra.modernappmvvm.Data.model.user.RandomUserApiResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebApiClient {
    private val Base_URL = "https://randomuser.me/";

    private val webApi: WebApi? = null
    var webApiClient: WebApiClient? = null
    private val mContext: Context? = null


    public fun getWebapi(): WebApi {
      val  retrofit = Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(WebApi::class.java)
    }

    fun getRandomUser(): Call<RandomUserApiResponse> =
        getWebapi().getRandomUser()


}