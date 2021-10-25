package com.example.drinksmvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.drinksmvvm.databinding.ActivityMainBinding
import com.example.drinksmvvm.databinding.AdapterDrinksBinding
import com.example.drinksmvvm.model.Drink
import com.example.drinksmvvm.model.Drinks

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){
   var drinksData = mutableListOf<Drink>()

    fun setDrinkList(drinksData: Drinks?) {
        if (drinksData != null) {
            this.drinksData = drinksData.drinks as MutableList<Drink>
            notifyDataSetChanged()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterDrinksBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
 override fun onBindViewHolder(holder: MainAdapter.MainViewHolder, position: Int) {
     val drink=drinksData[position]
     holder.binding.strInstructions.text = drink.strInstructions
     holder.binding.strCategory.text = drink.strCategory
     holder.binding.strGlass.text = drink.strGlass
    // holder.binding.strCategory.text = drink.strIBA
     holder.binding.dateModified.text = drink.dateModified
     Glide.with(holder.itemView.context).load(drink.strDrinkThumb).into(holder.binding.strDrinkThumb)
    }
    override fun getItemCount(): Int {
        return drinksData.size
    }



    class MainViewHolder(val binding: AdapterDrinksBinding):RecyclerView.ViewHolder(binding.root)
}