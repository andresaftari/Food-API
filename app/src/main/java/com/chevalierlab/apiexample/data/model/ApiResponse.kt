package com.chevalierlab.apiexample.data.model

data class DataResponse(
    var meals: List<Meal> = listOf()
)

data class Meal(
    var idMeal: String = "",
    var strMeal: String = "",
    var strMealThumb: String = ""
)