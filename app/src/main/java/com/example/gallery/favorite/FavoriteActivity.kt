package com.example.gallery.favorite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gallery.*
import com.example.gallery.contain.ContaintActivity
import com.example.gallery.databinding.ActivityFavoriteBinding
import com.example.gallery.picture.Picture
import com.example.gallery.profile.ProfileActivity
import java.text.SimpleDateFormat
import java.util.*

class FavoriteActivity : AppCompatActivity(), FavoriteAdapter.ListenerRecycler {

    lateinit var binding: ActivityFavoriteBinding
    private val adapter = FavoriteAdapter(this)
    var cContentOfView = ContentOfView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bNavigator.selectedItemId = R.id.favoriteActivity
        binding.bNavigator.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mainActivity -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.favoriteActivity -> {

                }
                R.id.profileActivity -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }
        init()
    }

    private fun init(){

        binding.apply {
            FavRecId.layoutManager = GridLayoutManager(this@FavoriteActivity, 1)
            FavRecId.adapter = adapter
            for(index in 0..(cContentOfView.imageIdList.size-1)){
                val picture = Picture(cContentOfView.imageIdList[index], cContentOfView.titleIdList[index],cContentOfView.discrIdList[index],cContentOfView.dateInString)
                adapter.addPicture(picture)
            }
        }
    }

    override fun onClickRecycler(picture: Picture) {
        val intent = Intent( this, ContaintActivity::class.java)
        intent.putExtra("item",picture)
        startActivity(intent)
    }
}