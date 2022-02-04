package com.example.news_app


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL="https://newsapi.org/"
const val API_KEY="5846d8f1ab0c414eb952f54a439f48d9"
interface NewsInterface {
    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadlines(@Query("country")country:String, @Query("page")page:Int):Call<News>

}


object NewsService{
    val newInstance:NewsInterface
    init {
        val retrofit:Retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newInstance=retrofit.create(NewsInterface::class.java)

    }
}