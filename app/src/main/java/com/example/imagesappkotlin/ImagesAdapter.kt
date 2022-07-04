package com.example.imagesappkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.example.ImageModelClass
import com.example.imagesappkotlin.View.MainActivity

class ImagesAdapter  (
    var mlistner: MainActivity,
    private val context: Context,


) : RecyclerView.Adapter<ImagesAdapter.MyViewHolder>() {
    private var imageList: List<ImageModelClass>? = null


    fun setMovieList(movieList: List<ImageModelClass>?) {
        this.imageList = movieList
    }

    fun setMovie(imageModelClass: ImageModelClass) {
        this.imageList = imageList
    }

    interface onItemClickListner {
        fun onItemClick(position: Int)
    }


    class MyViewHolder(view: View, listner: onItemClickListner) : RecyclerView.ViewHolder(view) {
        val imageUrl: ImageView = view.findViewById(R.id.imageView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.image_itemlayout, parent, false)
        )

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //  holder.bind()
        val imageListData = imageList?.get(position)
        Glide.with(context).load(imageListData?.url).into(holder.imageUrl)
    }

    override fun getItemCount(): Int {
        if (imageList == null)
            return 0
        else return imageList?.size!!
    }
}
