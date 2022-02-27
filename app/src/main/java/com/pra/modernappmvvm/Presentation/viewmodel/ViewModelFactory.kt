package com.pra.modernappmvvm.Presentation.viewmodel

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val app: Context): ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserListVIewModel::class.java)) {
            return UserListVIewModel(app) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}