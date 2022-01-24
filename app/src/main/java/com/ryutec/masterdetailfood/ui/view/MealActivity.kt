package com.ryutec.masterdetailfood.ui.view

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.ryutec.masterdetailfood.R
import com.ryutec.masterdetailfood.databinding.ActivityMealBinding
import com.ryutec.masterdetailfood.ui.viewmodel.HomeViewModel
import com.ryutec.masterdetailfood.ui.viewmodel.MealViewModel
import dagger.hilt.android.AndroidEntryPoint
import hilt_aggregated_deps._com_ryutec_masterdetailfood_ui_view_HomeFragment_GeneratedInjector

@AndroidEntryPoint
class MealActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMealBinding
    private val mealViewModel: MealViewModel by viewModels()


    private lateinit var mealId:String
    private lateinit var mealName:String
    private lateinit var mealThumb:String
    private lateinit var mealUrl:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showLoading()
        getMealInformation()

        onYoutubeImgClick()

        setInformationInViews()

        mealViewModel.onCreate(mealId)

        mealViewModel.detailsMeal.observe(this, {
            binding.instructions.text = it.strInstructions
            binding.categoty.text = it.strCategory
            binding.area.text = it.strArea
            mealUrl = it.strYoutube
            stopLoading()
        })
    }

    private fun onYoutubeImgClick() {
        binding.imgYt.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(mealUrl))
            startActivity(intent)
        }
    }

    private fun setInformationInViews() {
        Glide.with(this).load(mealThumb).into(binding.imgMealDeail)
        binding.collpTb.title = mealName
    }

    private fun getMealInformation() {
        val intent = intent
        mealId = intent.getStringExtra(HomeFragment.MEAL_ID)!!
        mealName = intent.getStringExtra(HomeFragment.MEAL_NAME)!!
        mealThumb = intent.getStringExtra(HomeFragment.MEAL_THUMB)!!

    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.tvInstructions.visibility = View.GONE
        binding.area.visibility = View.INVISIBLE
        binding.categoty.visibility = View.INVISIBLE
        binding.imgYt.visibility = View.INVISIBLE
    }


    private fun stopLoading() {
        binding.progressBar.visibility = View.INVISIBLE
        binding.tvInstructions.visibility = View.VISIBLE
        binding.area.visibility = View.VISIBLE
        binding.categoty.visibility = View.VISIBLE
        binding.imgYt.visibility = View.VISIBLE

    }
}