package com.example.news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var adapter:Myadepter
    var pageNo=1
    var totalResult=-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getNews()
    }

    private fun getNews() {
        val news:Call<News> =NewsService.newInstance.getHeadlines("in",pageNo)
        news.enqueue(object :Callback<News>{
            override fun onFailure(call: Call<News>, t: Throwable) {


            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news:News?=response.body()
                if(news!=null)
                {
                    totalResult=news.totalResults
                    adapter= Myadepter(this@MainActivity,news.articles)
                    Newslist.adapter=adapter
                    Newslist.layoutManager=LinearLayoutManager(this@MainActivity)
                }
            }
        })

    }
}