package com.example.taskapp53.data.local
import android.content.Context
import android.content.Context.MODE_PRIVATE

class Pref(context: Context) {
    private val pref = context.getSharedPreferences(PREF_NAME, MODE_PRIVATE)

    fun isUserSeen(): Boolean{
        return pref.getBoolean(ONBOARD_KEY, false)
    }


    fun saveSeen(){
        pref.edit().putBoolean(ONBOARD_KEY, true).apply()
    }

    fun setUser(name: String){
        pref.edit().putString(NAME_KEY, name).apply()
    }


    fun getUser(): String{
        return pref.getString(NAME_KEY, "").toString()
    }

    fun setImage(image: String){
       pref.edit().putString(IMAGE_KEY, image).apply()
    }

    fun getImage(): String {
       return pref.getString(IMAGE_KEY, "").toString()
    }
    companion object{
        const val PREF_NAME = "task.name.53"
        const val ONBOARD_KEY = "onBoardKey"
        const val NAME_KEY = "nameKey"
        const val IMAGE_KEY = "imageKey"

    }
}