package com.pra.modernappmvvm.Data.api

import android.content.Context
import com.pra.modernappmvvm.Data.model.user.RandomUserApiResponse
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor




class WebApiClient(private val context: Context) {
    private val Base_URL = "https://randomuser.me/";

    private val webApi: WebApi? = null
    var webApiClient: WebApiClient? = null
    private val mContext: Context? = null


    public fun getWebapi(): WebApi {
        val cacheSize = (5 * 1024 * 1024).toLong()
        val myCache = Cache(context.cacheDir, cacheSize)

        System.setProperty("http.keepAlive", "false")

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(logging).build()
        client.connectTimeoutMillis

        val retrofit = Retrofit.Builder()
            .baseUrl(Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        return retrofit.create(WebApi::class.java)
    }

    fun getRandomUser(): Call<RandomUserApiResponse> =
        getWebapi().getRandomUser()


}