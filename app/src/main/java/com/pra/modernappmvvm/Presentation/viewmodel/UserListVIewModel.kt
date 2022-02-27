package com.pra.modernappmvvm.Presentation.viewmodel

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pra.modernappmvvm.Data.api.WebApiClient
import com.pra.modernappmvvm.Data.db.AppDataBase
import com.pra.modernappmvvm.Data.model.user.RandomUserApiResponse
import com.pra.modernappmvvm.Data.model.user.User
import com.pra.modernappmvvm.Presentation.ModernApp
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserListVIewModel(private val app: Context) : ViewModel() {
    val users = MutableLiveData<List<User>>()
    val countryLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()
    var webApiClient: WebApiClient? = WebApiClient()

    private lateinit var mAppDb: AppDataBase

    init {
        mAppDb = AppDataBase.getDatabase(app)
    }

    fun refresh() {
        checkInDb()

    }

    private fun checkInDb() {
        var list: List<User> = ArrayList()
        runBlocking {
          val deferred=  async {
                list = mAppDb.userDaO().getAllUser()
            }
            deferred.await()
            println("size init of Db=====>${list.size}")
            fetchCountry()
            users.value = list
        }

    }

    private fun fetchCountry() {
        loading.value = true
        var responsecall: Call<RandomUserApiResponse> = WebApiClient().getRandomUser()
        responsecall.enqueue(object : Callback<RandomUserApiResponse> {
            override fun onResponse(
                call: Call<RandomUserApiResponse>,
                response: Response<RandomUserApiResponse>
            ) {
                loading.value = false
                when {
                    response.isSuccessful -> {
                        val responseBody = response.body()
                        if (response != null) {
                            val randomUserApiResponse = responseBody
                            var list: List<User> = ArrayList()
                            runBlocking {
                                val deferred = async {
                                    mAppDb.userDaO().deleteAllUser()
                                }
                                val wait = deferred.await()
                                val savedeferred = async {
                                    mAppDb.userDaO().saveUser(randomUserApiResponse?.users!!)
                                }
                                val waitSave = savedeferred.await()

                                val select = async {
                                    list = mAppDb.userDaO().getAllUser()
                                }
                            }

                            println("size of Db=====>${list.size}")
                            users.value = list
                        } else {
                            countryLoadError.value = true
                        }
                    }
                    response.errorBody() != null -> countryLoadError.value = true
                    else -> countryLoadError.value = true
                }
            }

            override fun onFailure(call: Call<RandomUserApiResponse>, t: Throwable) {
                loading.value = false
                countryLoadError.value = true
            }

        })


    }


    override fun onCleared() {
        super.onCleared()
    }

}