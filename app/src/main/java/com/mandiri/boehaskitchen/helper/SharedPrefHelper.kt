package com.mandiri.boehaskitchen.helper

import android.content.SharedPreferences

class SharedPrefHelper (private val sharedPref: SharedPreferences){

    fun saveToken(token: String){
        sharedPref.edit().putString(TOKEN_KEY, token).apply()
    }

    fun getToken(): String{
        return sharedPref.getString(TOKEN_KEY, null) ?: ""
    }

    fun clearDataPref(){
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }

    companion object{
        private const val TOKEN_KEY = "token_key"
    }
}