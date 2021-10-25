package com.example.drinksmvvm.view

import com.example.drinksmvvm.util.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
fun getAllDrinks() = retrofitService.getAllDrinks()
}
