package com.chevalierlab.apiexample.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chevalierlab.apiexample.data.model.Meal
import com.chevalierlab.apiexample.databinding.FoodItemBinding

class MainAdapter(
    private var items: List<Meal>,
    var handler: (Meal) -> Unit
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainViewHolder(
        FoodItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) = with(holder) {
        bind(items[position])
        binding.root.setOnClickListener { handler(items[position]) }
    }

    override fun getItemCount() = items.size

    class MainViewHolder(val binding: FoodItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Meal) = with(binding) {
            Glide.with(this.root)
                .load(data.strMealThumb)
                .into(ivAvatar)

            tvName.text = data.strMeal
        }
    }
}