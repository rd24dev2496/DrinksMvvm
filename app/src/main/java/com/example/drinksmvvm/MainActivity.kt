package com.example.drinksmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.drinksmvvm.databinding.ActivityMainBinding
import com.example.drinksmvvm.util.RetrofitService
import com.example.drinksmvvm.view.MainAdapter
import com.example.drinksmvvm.view.MainRepository
import com.example.drinksmvvm.viewmodel.MainViewModel
//This is my Main Activity(Experimental Branch)
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
        )
        binding.recyclerview.adapter = adapter
        viewModel.drinkList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setDrinkList(it)
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getAllDrinks()
    }

    fun redirect(view: View) {
        val intent = Intent(this,SecondActivity::class.java)
        startActivity(intent)
    }
}