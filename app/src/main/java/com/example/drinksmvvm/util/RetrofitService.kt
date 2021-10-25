package com.example.drinksmvvm.util

import com.example.drinksmvvm.model.Drinks
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("json/v1/1/search.php?s=margarita")
    fun getAllDrinks(): Call<Drinks>

    companion object{
        var retrofitService: RetrofitService?= null;
        fun getInstance(): RetrofitService{
            if(retrofitService==null)
            {
                val retrofit=Retrofit.Builder()
                    .baseUrl("https://www.thecocktaildb.com/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService=retrofit.create(RetrofitService::class.java)
            }
           return  retrofitService!!
        }
    }
}