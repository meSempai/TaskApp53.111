package com.example.taskapp53.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.taskapp53.model.Task

@Dao
interface TaskDao {

    @Insert
    fun inserts(task: Task)

    @Query("SELECT * FROM task ORDER BY title ASC")
    fun getAll(): List<Task>

    @Delete
    fun delete(task: Task)
}