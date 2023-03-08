package com.innov.sherehify.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.ktx.Firebase
import com.innov.sherehify.R
import com.innov.sherehify.data.Myadapter
import com.innov.sherehify.data.Trending
import com.innov.sherehify.databinding.FragmentTrendingBinding


class Dashmain : Fragment() {

    private lateinit var binding: FragmentTrendingBinding

    private lateinit var adapter : Myadapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var TrendingArrayList : ArrayList<Trending>

    lateinit var imageId : ArrayList<Int>
    lateinit var heading : ArrayList<String>
    lateinit var trending: ArrayList<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashmain, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = Myadapter(TrendingArrayList)
        recyclerView.adapter = adapter



    }
    private fun dataInitialize(){
        TrendingArrayList = arrayListOf<Trending>()
        imageId = arrayListOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,

        )
        heading = arrayListOf(
            getString(R.string.entertainment),
            getString(R.string.open),
            getString(R.string.close),

        )
        trending = arrayListOf(
            getString(R.string.entertainment),
            getString(R.string.open),
            getString(R.string.close),
        )
        for ( i in imageId.indices){

            val trending = Trending(imageId[i],heading[i])
            TrendingArrayList.add(trending)
        }
    }
    private fun fetchdate(){


    }


}