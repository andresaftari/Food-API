package com.chevalierlab.apiexample.data.api

import com.chevalierlab.apiexample.data.model.DataResponse
import retrofit2.http.GET

interface ApiEndpoint {
    // Contohnya kita cari makanan yang berupa Seafood,
    // dari dokumentasi API yang kita gunakan (https://www.themealdb.com/api.php),
    // untuk mendapatkan Seafood, kita harus pake Endpoint seperti di bawah :
    @GET("filter.php?c=Seafood")
    suspend fun getSeafood(): DataResponse
}