package com.mandiri.boehaskitchen.presentation

import ListMenuAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mandiri.bebasinaja.base.BaseFragment
import com.mandiri.boehaskitchen.MainActivity
import com.mandiri.boehaskitchen.databinding.FragmentCategorymenuBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

class FragmentCategorymenu : BaseFragment<FragmentCategorymenuBinding>() {

    private val listMenuAdapter : ListMenuAdapter = ListMenuAdapter(mutableListOf())

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCategorymenuBinding {
        return FragmentCategorymenuBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        binding.componentHomeMenu.rvMenu.adapter = listMenuAdapter

        listMenuAdapter.setOnClickDetailMenuModel { mealId ->
            val fragmentToDisplay = FragmentDetailMenu.newInstance(mealId)
            (requireActivity() as MainActivity).replaceFragment(fragmentToDisplay)
        }

        GlobalScope.launch(Dispatchers.Main) {
            getMealList()
        }

        binding.componentHomeHeader.ivListMenu.setOnClickListener{
            val fragmentToDisplay = FragmentNavigationMenu()
            (requireActivity() as MainActivity).replaceFragment(fragmentToDisplay)
        }
        binding.componentHomeHeader.icWishlist.setOnClickListener{
            val fragmentToDisplay = FragmentWishlist()
            (requireActivity() as MainActivity).replaceFragment(fragmentToDisplay)
        }
    }

    suspend fun getMealList(){
        RetrofitInstance.api.getMealList("Seafood").enqueue(object : Callback<MealList>{
            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                if (response.body() != null) {
                    val value = response.body()!!.meals
                    listMenuAdapter.setDataMenu(value.toMutableList())
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