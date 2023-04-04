package com.example.taskapp53

import com.example.taskapp53.data.local.db.AppDatabase
import android.app.Application
import androidx.room.Room

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }

    companion object {
        lateinit var db: AppDatabase
    }
}