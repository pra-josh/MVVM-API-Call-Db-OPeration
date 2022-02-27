package com.pra.modernappmvvm.Presentation

import android.app.Application
import com.pra.modernappmvvm.Data.db.AppDataBase

class ModernApp : Application() {


    companion object {
        private var instance: ModernApp? = null
        fun getAppInstance(): ModernApp {
            if (instance == null) {
                instance = ModernApp()
            }
            return instance!!
        }
    }


//    public  var db:AppDataBase =  AppDataBase.getDatabase(this)

    override fun onCreate() {
        super.onCreate()
       // db=   AppDataBase.getDatabase(this)

    }



}