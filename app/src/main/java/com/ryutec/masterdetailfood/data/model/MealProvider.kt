package com.ryutec.masterdetailfood.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MealProvider @Inject constructor() {
    lateinit var  Meals: MealList
}