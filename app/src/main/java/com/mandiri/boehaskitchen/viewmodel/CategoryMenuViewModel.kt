package com.mandiri.boehaskitchen.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandiri.boehaskitchen.model.Meal
import com.mandiri.boehaskitchen.model.MealList
import com.mandiri.boehaskitchen.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryMenuViewModel : ViewModel() {

    val mealListLiveData: MutableLiveData<List<Meal>> = MutableLiveData()

    fun getMealList(category: String) {
        RetrofitInstance.api.getMealList(category).enqueue(object : Callback<MealList> {
            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                if (response.body() != null) {
                    mealListLiveData.postValue(response.body()?.meals)
                }
            }

            override fun onFailure(call: Call<MealList>, t: Throwable) {
            }
        })
    }
}
