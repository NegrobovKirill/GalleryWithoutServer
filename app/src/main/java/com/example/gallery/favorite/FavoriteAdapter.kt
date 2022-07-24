package com.example.gallery.favorite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.R
import com.example.gallery.databinding.FavoriteItemBinding
import com.example.gallery.databinding.PictureItemBinding
import com.example.gallery.picture.Picture
import com.example.gallery.picture.PictureAdapter

class FavoriteAdapter(val listenerRecycler: ListenerRecycler): RecyclerView.Adapter<FavoriteAdapter.FavoriteHolder>() {
    val pictureList = ArrayList<Picture>()
    class FavoriteHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = FavoriteItemBinding.bind(item)
        fun bind(picture: Picture, listenerRecycler: ListenerRecycler) = with(binding){
            favoriteView.setImageResource(picture.imageId)
            titlePicture.text = picture.title
            textData.text = picture.addTime
            textView.text = picture.discription
            itemView.setOnClickListener{
                listenerRecycler.onClickRecycler(picture)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favorite_item, parent, false)
        return FavoriteHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteHolder, position: Int) {
        holder.bind(pictureList[position], listenerRecycler)
    }

    override fun getItemCount(): Int {
        return  pictureList.size
    }

    fun addPicture(picture: Picture){
        pictureList.add(picture)
        notifyDataSetChanged()
    }

    interface ListenerRecycler{
        fun onClickRecycler(picture: Picture)
    }
}