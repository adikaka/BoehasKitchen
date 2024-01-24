package com.mandiri.boehaskitchen.presentation

import CategoryMenuAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mandiri.bebasinaja.base.BaseFragment
import com.mandiri.boehaskitchen.MainActivity
import com.mandiri.boehaskitchen.R
import com.mandiri.boehaskitchen.databinding.FragmentHomeBinding
import com.mandiri.boehaskitchen.model.CategoryMenuModel

class FragmentHome : BaseFragment<FragmentHomeBinding>() {

    private lateinit var categoryMenuAdapter: CategoryMenuAdapter

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        setupViewCategoryMenu()
        binding.componentHomeHeader.ivListMenu.setOnClickListener{
            val fragmentToDisplay = FragmentNavigationMenu()
            (requireActivity() as MainActivity).replaceFragment(fragmentToDisplay)
        }
        binding.componentHomeHeader.icWishlist.setOnClickListener{
            val fragmentToDisplay = FragmentWishlist()
            (requireActivity() as MainActivity).replaceFragment(fragmentToDisplay)
        }
    }

    private fun setupViewCategoryMenu(){
        categoryMenuAdapter = CategoryMenuAdapter(populateCategoryMenuData())
        binding.componentHomeMenu.rvMenu.adapter = categoryMenuAdapter
        categoryMenuAdapter.setOnClickCategoriModel {
            val fragmentToDisplay = FragmentCategorymenu()
            (requireActivity() as MainActivity).replaceFragment(fragmentToDisplay)
        }

    }

    private fun populateCategoryMenuData(): MutableList<CategoryMenuModel> {
        return mutableListOf(
            CategoryMenuModel(
                name = "Main Diches",
                rating = "4.9",
                respon = "(355 ratings)",
                price = "Rp 25.000",
                imageCard = R.drawable.img_maindiches
            ),
            CategoryMenuModel(
                name = "Best Seller",
                rating = "4.8",
                respon = "(105 ratings)",
                price = "Rp 20.000",
                imageCard = R.drawable.img_bestseller
            ),
            CategoryMenuModel(
                name = "Discounted Offers",
                rating = "4.6",
                respon = "(555 ratings)",
                price = "Rp 15.000",
                imageCard = R.drawable.img_discount
            ),
        )
    }
}