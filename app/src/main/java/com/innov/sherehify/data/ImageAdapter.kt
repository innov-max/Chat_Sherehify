package com.innov.sherehify.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.innov.sherehify.R
import com.innov.sherehify.activities.storage.UserImage
import com.innov.sherehify.fragments.Trending

class ImageAdapter(private val imagesList: ArrayList<UserImage>,
                   private val context: Trending
)
    :RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.profile_image)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder { val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_fire,parent,false)
        return ImageViewHolder(itemView)
        
    }

    override fun getItemCount(): Int {
        return  imagesList.size

    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Glide.with(context).load(imagesList[position].userImage).into(holder.image)

    }
}