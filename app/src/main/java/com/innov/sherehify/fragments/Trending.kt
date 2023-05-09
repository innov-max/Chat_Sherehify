package com.innov.sherehify.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.google.firebase.database.*
import com.innov.sherehify.activities.storage.UserImage
import com.innov.sherehify.data.ImageAdapter
import com.innov.sherehify.databinding.FragmentTrendingBinding

class Trending : Fragment() {
    private var _binding: FragmentTrendingBinding? = null
    private lateinit var  recyclerView: RecyclerView
    private lateinit var imagesList : ArrayList<UserImage>
    private lateinit var databaseReference: DatabaseReference
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        recyclerView = binding.recyclerFire
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        imagesList = arrayListOf()
        databaseReference = FirebaseDatabase.getInstance().getReference("userImages")
        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
               if (snapshot.exists()){

                   for (dataSnapshot in snapshot.children){
                       val image = dataSnapshot.getValue(UserImage::class.java)
                       imagesList.add(image!!)
                   }
                   recyclerView.adapter = ImageAdapter(imagesList,this@Trending)
               }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })


        // Inflate the layout for this fragment
        return binding.root
        }


}