package com.chevalierlab.apiexample.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.chevalierlab.apiexample.databinding.ActivityMainBinding
import com.chevalierlab.apiexample.utils.MainAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var mainAdapter: MainAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MainViewModel::class.java)

        fetchData()


    }

    private fun fetchData() = with(viewModel) {
        getSeafoodList()
        meal.observe(this@MainActivity) {
            mainAdapter = MainAdapter(it.meals) { meal ->
                Toast.makeText(
                    this@MainActivity,
                    "Selected, ${meal.strMeal}!",
                    Toast.LENGTH_SHORT
                ).show()
            }

            with(binding.rvMain) {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = mainAdapter
            }
        }
    }
}