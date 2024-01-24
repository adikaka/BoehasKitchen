package com.mandiri.boehaskitchen.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.mandiri.bebasinaja.base.BaseFragment
import com.mandiri.boehaskitchen.databinding.FragmentDetailMenuBinding
import com.mandiri.boehaskitchen.viewmodel.DetailMenuViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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

    private lateinit var detailMenuViewModel: DetailMenuViewModel

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailMenuBinding {
        return FragmentDetailMenuBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        detailMenuViewModel = ViewModelProvider(this).get(DetailMenuViewModel::class.java)

        GlobalScope.launch(Dispatchers.Main) {
            val mealId = arguments?.getString(ARG_MEAL_ID)
            if (!mealId.isNullOrBlank()) {
                detailMenuViewModel.getMealDetails(mealId)
            }
        }

        detailMenuViewModel.mealDetailsLiveData.observe(viewLifecycleOwner, { mealList ->
            binding.detailMenuHeader.etNameDetailMenu.text = mealList?.meals?.get(0)?.strMeal
            Glide.with(requireContext()).load(mealList?.meals?.get(0)?.strMealThumb).into(binding.detailMenuHeader.ivFoodHeader)
            binding.detailMenuIngridient.tvIngreOne.text = mealList?.meals?.get(0)?.strIngredient1
            binding.detailMenuIngridient.tvIngreTwo.text = mealList?.meals?.get(0)?.strIngredient2
            binding.detailMenuIngridient.tvIngreThree.text = mealList?.meals?.get(0)?.strIngredient3
            binding.detailMenuIngridient.tvIngreFour.text = mealList?.meals?.get(0)?.strIngredient4
        })

        binding.detailMenuHeader.ivListMenu.setOnClickListener{
            requireActivity().onBackPressed()
        }
    }


}

