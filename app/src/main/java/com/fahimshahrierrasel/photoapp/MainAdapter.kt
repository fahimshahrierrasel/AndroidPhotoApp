package com.fahimshahrierrasel.photoapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.fahimshahrierrasel.photoapp.models.Photo

/**
 * Created by fahim on 29/9/17.
 */
class MainAdapter(var photos: List<Photo>, var clickListener: View.OnClickListener) :
        RecyclerView.Adapter<MainAdapter.PhotoViewHolder>() {


    override fun onBindViewHolder(holder: PhotoViewHolder?, position: Int) {
        val photo = photos[position]
        holder?.tags?.text = photo.tags.toString()
        holder?.likes?.text = photo.likes.toString()
        holder?.favorites?.text = photo.favorites.toString()
        if (photo.previewURL.isNotEmpty()){
            Glide.with(holder?.tags?.context)
                    .load(photo.previewURL)
                    .into(holder?.photoItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.photo_item, parent, false))
    }

    fun getPhoto(adapterPosition: Int): Photo {
        return photos[adapterPosition]
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    inner class PhotoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tags : TextView
        var likes : TextView
        var favorites : TextView
        var photoItem : ImageView
        init {
            if (clickListener != null){
                itemView.setOnClickListener(clickListener)
            }
            itemView.tag = this
            tags = itemView.findViewById(R.id.tags)
            likes = itemView.findViewById(R.id.likes)
            favorites = itemView.findViewById(R.id.favorites)
            photoItem = itemView.findViewById(R.id.photo_item)
        }

    }
}