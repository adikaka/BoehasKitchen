package com.mandiri.boehaskitchen.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandiri.boehaskitchen.model.MealList
import com.mandiri.boehaskitchen.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailMenuViewModel : ViewModel() {

    val mealDetailsLiveData: MutableLiveData<MealList> = MutableLiveData()

    fun getMealDetails(mealId: String?) {
        if (!mealId.isNullOrBlank()) {
            RetrofitInstance.api.getMealDetails(mealId).enqueue(object : Callback<MealList> {
                override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                    if (response.body() != null) {
                        mealDetailsLiveData.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<MealList>, t: Throwable) {
                }
            })
        }
    }
}
