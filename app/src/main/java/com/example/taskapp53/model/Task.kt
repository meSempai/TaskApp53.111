package com.example.taskapp53.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    var title:String?=null,
    var desc:String?=null,
): java.io.Serializable
