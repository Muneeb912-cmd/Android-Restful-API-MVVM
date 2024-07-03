package com.example.week_3_challenge_3_1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.week_3_challenge_3_1.R
import com.example.week_3_challenge_3_1.adapters.RecyclerViewAdapter
import com.example.week_3_challenge_3_1.model.NewsData


class NewsDetails : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_news_details, container, false)
        val newsData = arguments?.getSerializable("newsData") as NewsData?


        view.findViewById<TextView>(R.id.detailNewsTitle).text = newsData?.articles?.get(0)?.title
        view.findViewById<TextView>(R.id.detailNewsAuthor).text = newsData?.articles?.get(0)?.author
        view.findViewById<TextView>(R.id.detailNewsPublishedAt).text = newsData?.articles?.get(0)?.publishedAt
        view.findViewById<TextView>(R.id.detailNewsDescription).text = newsData?.articles?.get(0)?.description
        view.findViewById<TextView>(R.id.detailNewsContent).text = newsData?.articles?.get(0)?.content
        Glide.with(view.findViewById<ImageView>(R.id.detailNewsImage).context)
            .load(newsData?.articles?.get(0)?.urlToImage)
            .into(view.findViewById(R.id.detailNewsImage))

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val backButton = view.findViewById<ImageButton>(R.id.back)
        bacButtonPressed(backButton)

    }

    private fun bacButtonPressed(backButton: ImageButton) {
        backButton.setOnClickListener() {
            val newFragment = RecyclerViewFragment()
            // Navigate to the new fragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, newFragment)
                .addToBackStack(null)
                .commit()
        }
    }
}