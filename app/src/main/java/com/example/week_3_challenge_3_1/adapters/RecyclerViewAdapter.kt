package com.example.week_3_challenge_3_1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.week_3_challenge_3_1.R
import com.example.week_3_challenge_3_1.model.Article


class RecyclerViewAdapter(
    private val dataList: List<Article>
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.newsTitle.text = dataList[position].title
        holder.publishedAt.text = dataList[position].publishedAt
        holder.author.text = dataList[position].author
        holder.id.text = dataList[position].source.id
        Glide.with(holder.imgViewer.context)
            .load(dataList[position].urlToImage)
            .into(holder.imgViewer)

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsTitle = itemView.findViewById<TextView>(R.id.newsTitle)
        val author = itemView.findViewById<TextView>(R.id.author)
        val publishedAt = itemView.findViewById<TextView>(R.id.publishedTime)
        val id = itemView.findViewById<TextView>(R.id.newsId)
        val imgViewer = itemView.findViewById<ImageView>(R.id.cardImage1)

    }
}

