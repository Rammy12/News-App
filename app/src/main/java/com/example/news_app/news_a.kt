package com.example.news_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_news.*

class news_a : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        val url=intent.getStringExtra("URL")
        if(url !=null)
        {
            deataileebview.settings.javaScriptEnabled=true
            deataileebview.settings.userAgentString="Mozilla/5.0 (iPhone; U; CPU like Mac OS X; en) AppleWebKit/420+ (KHTML, like Gecko) Version/3.0 Mobile/1A543a Safari/419.3"

            deataileebview.webViewClient= object :WebViewClient()
            {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    progressBar.visibility=View.GONE
                    deataileebview.visibility=View.VISIBLE
                }
            }
            deataileebview.loadUrl(url)
        }
    }
}