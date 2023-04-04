package com.example.taskapp53.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.taskapp53.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}