package com.example.week_3_challenge_3_1.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week_3_challenge_3_1.R
import com.example.week_3_challenge_3_1.adapters.RecyclerViewAdapter
import com.example.week_3_challenge_3_1.model.Article
import com.example.week_3_challenge_3_1.model.NewsData
import com.example.week_3_challenge_3_1.model.NewsDataRepository
import com.example.week_3_challenge_3_1.view_model.NewsViewModel

class RecyclerViewFragment : Fragment(),RecyclerViewAdapter.OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewAdapter
    private var dataList = ArrayList<NewsData>()
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recycler_view, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        val newsRepo=NewsDataRepository()
        newsViewModel=NewsViewModel(newsRepo)
        newsViewModel.getNewsListObserver().observe(viewLifecycleOwner, Observer { data ->
            data?.let {
                setUpRecyclerView(data.articles)
            }
        })
        newsViewModel.apiCall()
        return view
    }

    private fun setUpRecyclerView(articles: List<Article>) {
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        adapter = RecyclerViewAdapter(articles,this)
        recyclerView.adapter = adapter
    }

    override fun onButtonClick(title: String) {
        newsViewModel.fetchNewsByTitle(title)

        newsViewModel.getNewsListObserver().observe(viewLifecycleOwner, Observer { data ->
            data?.let {
                val newFragment = NewsDetails()

                // Pass data to the new fragment (if needed)
                val bundle = Bundle()
                bundle.putSerializable("newsData", data)
                newFragment.arguments = bundle

                // Navigate to the new fragment
                parentFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, newFragment)
                    .addToBackStack(null)
                    .commit()
            }
        })
    }

}