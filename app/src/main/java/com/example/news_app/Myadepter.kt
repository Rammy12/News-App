package com.example.news_app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Myadepter (val context: Context,val artical:List<Artical>):RecyclerView.Adapter<Myadepter.ArticalViewHolder>(){

    class ArticalViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var NewsImage=itemView.findViewById<ImageView>(R.id.image)
        var Headline=itemView.findViewById<TextView>(R.id.headline)
        var Description=itemView.findViewById<TextView>(R.id.description)
    }

    override fun onBindViewHolder(holder: ArticalViewHolder, position: Int) {
        val artical=artical[position]
        holder.Headline.text=artical.title
        holder.Description.text=artical.description
        Glide.with(context).load(artical.urlToImage).into(holder.NewsImage)
        holder.itemView.setOnClickListener {
            val intent=Intent(context,news_a::class.java)
            intent.putExtra("URL",artical.url)
            context.startActivity(intent)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticalViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.item_view,parent,false)
        return ArticalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return artical.size

    }
}