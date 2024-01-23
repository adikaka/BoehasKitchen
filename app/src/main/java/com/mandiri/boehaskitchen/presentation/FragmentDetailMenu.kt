package com.mandiri.boehaskitchen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mandiri.bebasinaja.base.BaseFragment
import com.mandiri.boehaskitchen.MainActivity
import com.mandiri.boehaskitchen.databinding.FragmentDetailMenuBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentDetailMenu : BaseFragment<FragmentDetailMenuBinding>() {

    companion object {
        private const val ARG_MEAL_ID = "mealId"

        fun newInstance(mealId: Any?): FragmentDetailMenu {
            val fragment = FragmentDetailMenu()
            val args = Bundle()
            args.putString(ARG_MEAL_ID, mealId.toString())
            fragment.arguments = args
            return fragment
        }
    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailMenuBinding {
        return FragmentDetailMenuBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        GlobalScope.launch(Dispatchers.Main) {
            val mealId = arguments?.getString(ARG_MEAL_ID)
            if (!mealId.isNullOrBlank()) {
                getMeal(mealId)
            }
        }
        binding.detailMenuHeader.ivListMenu.setOnClickListener{
            requireActivity().onBackPressed()
        }
    }

    suspend fun getMeal(mealId: String?){
        // Gunakan mealId yang diberikan saat melakukan panggilan API
        if (mealId.isNullOrBlank()) {
            return
        }

        RetrofitInstance.api.getMealDetails(mealId).enqueue(object : Callback<MealList>{
            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                if (response.body() != null) {
                    val value = response.body()!!.meals[0]
                    binding.detailMenuHeader.etNameDetailMenu.text = value.strMeal
                    Glide.with(requireContext()).load(value.strMealThumb).into(binding.detailMenuHeader.ivFoodHeader)

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

