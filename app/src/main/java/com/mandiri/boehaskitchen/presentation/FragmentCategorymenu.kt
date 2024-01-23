package com.mandiri.boehaskitchen.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.mandiri.bebasinaja.base.BaseFragment
import com.mandiri.boehaskitchen.MainActivity
import com.mandiri.boehaskitchen.databinding.FragmentCategorymenuBinding
import com.mandiri.boehaskitchen.databinding.FragmentHomeBinding
import com.mandiri.boehaskitchen.databinding.FragmentWishlistBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class FragmentCategorymenu : BaseFragment<FragmentCategorymenuBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCategorymenuBinding {
        return FragmentCategorymenuBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

    }

    suspend fun getMeal(){
        RetrofitInstance.api.getMealList("Seafood").enqueue(object : Callback<MealList>{
            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                if (response.body() != null) {
                    val value = response.body()!!.meals[0]
                    binding.
                }
                else {
                    return
                }
            }

            override fun onFailure(call: Call<MealList>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}

object RetrofitInstance {
    val api:MealApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MealApi::class.java)
    }
}

interface MealApi {
    @GET("lookup.php?")
    fun getMealDetails(@Query("i") id: String): Call<MealList>

    @GET("filter.php?")
    fun getMealList(@Query("c") id: String): Call<MealList>
}


data class MealList(
    val meals: List<Meal>
)

data class Meal(
    val idMeal: String,
    val strCategory: String?,
    val strMeal: String?,
    val strMealThumb: String?
)