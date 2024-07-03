package com.example.week_3_challenge_3_1.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class NewsData(
    @SerializedName("articles")
    var articles: List<Article>,
    @SerializedName("status")
    var status: String,
    @SerializedName("totalResults")
    var totalResults: Int
):Serializable

data class Article(
    @SerializedName("author")
    var author: String,
    @SerializedName("content")
    var content: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("publishedAt")
    var publishedAt: String,
    @SerializedName("source")
    var source: Source,
    @SerializedName("title")
    var title: String,
    @SerializedName("url")
    var url: String,
    @SerializedName("urlToImage")
    var urlToImage: String
)

data class Source(
    @SerializedName("id")
    var id: String,
    @SerializedName("name")
    var name: String
)