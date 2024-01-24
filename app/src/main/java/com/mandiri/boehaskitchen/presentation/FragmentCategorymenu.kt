package com.mandiri.boehaskitchen.presentation

import ListMenuAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.mandiri.bebasinaja.base.BaseFragment
import com.mandiri.boehaskitchen.MainActivity
import com.mandiri.boehaskitchen.databinding.FragmentCategorymenuBinding
import com.mandiri.boehaskitchen.viewmodel.CategoryMenuViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FragmentCategorymenu : BaseFragment<FragmentCategorymenuBinding>() {

    private lateinit var categoryMenuViewModel: CategoryMenuViewModel
    private val listMenuAdapter : ListMenuAdapter = ListMenuAdapter(mutableListOf())

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCategorymenuBinding {
        return FragmentCategorymenuBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        categoryMenuViewModel = ViewModelProvider(this).get(CategoryMenuViewModel::class.java)

        binding.componentHomeMenu.rvMenu.adapter = listMenuAdapter

        listMenuAdapter.setOnClickDetailMenuModel { mealId ->
            val fragmentToDisplay = FragmentDetailMenu.newInstance(mealId)
            (requireActivity() as MainActivity).replaceFragment(fragmentToDisplay)
        }

        categoryMenuViewModel.mealListLiveData.observe(viewLifecycleOwner, { mealList ->
            mealList?.toMutableList()?.let { listMenuAdapter.setDataMenu(it) }
        })

        GlobalScope.launch(Dispatchers.Main) {
            categoryMenuViewModel.getMealList("Seafood")
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
}