package com.mandiri.boehaskitchen.retrofit

import com.mandiri.boehaskitchen.model.MealList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {
    @GET("lookup.php?")
    fun getMealDetails(@Query("i") id: String): Call<MealList>

    @GET("filter.php?")
    fun getMealList(@Query("c") id: String): Call<MealList>
}