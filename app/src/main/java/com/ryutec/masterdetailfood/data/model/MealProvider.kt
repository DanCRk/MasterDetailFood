package com.ryutec.masterdetailfood.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealProvider @Inject constructor() {
    lateinit var   meals: MealList
    lateinit var   popularMeals: CategoryList
}