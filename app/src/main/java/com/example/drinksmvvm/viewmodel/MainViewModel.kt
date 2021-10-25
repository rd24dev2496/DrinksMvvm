package com.example.drinksmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.drinksmvvm.model.Drinks
import com.example.drinksmvvm.view.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository):ViewModel() {
    var drinkList = MutableLiveData<Drinks>()
    val errorMessage = MutableLiveData<String>()

    fun getAllDrinks() {
        val response = repository.getAllDrinks()
        response.enqueue(object : Callback<Drinks?> {

            override fun onResponse(call: Call<Drinks?>, response: Response<Drinks?>) {

                drinkList.postValue(response.body())
            }


            override fun onFailure(call: Call<Drinks?>, t: Throwable) {
            }

        })

    }
}
