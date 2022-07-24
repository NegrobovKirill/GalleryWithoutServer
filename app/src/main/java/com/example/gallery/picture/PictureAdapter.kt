package com.example.gallery.picture

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gallery.R
import com.example.gallery.databinding.PictureItemBinding

class PictureAdapter(val listenerRecycler: ListenerRecycler): RecyclerView.Adapter<PictureAdapter.PictureHolder>() {
    val pictureList = ArrayList<Picture>()
    class PictureHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = PictureItemBinding.bind(item)
        fun bind(picture: Picture, listenerRecycler: ListenerRecycler) = with(binding){
            imageItem.setImageResource(picture.imageId)
            pictureTitle.text = picture.title
            itemView.setOnClickListener{
                listenerRecycler.onClickRecycler(picture)
            }
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.picture_item, parent, false)
        return PictureHolder(view)
    }

    override fun onBindViewHolder(holder: PictureHolder, position: Int) {
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