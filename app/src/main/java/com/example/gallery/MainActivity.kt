package com.example.gallery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.ToggleButton
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gallery.contain.ContaintActivity
import com.example.gallery.databinding.ActivityMainBinding
import com.example.gallery.favorite.FavoriteActivity
import com.example.gallery.picture.Picture
import com.example.gallery.picture.PictureAdapter
import com.example.gallery.profile.ProfileActivity
import com.example.gallery.ContentOfView
import com.example.gallery.databinding.PictureItemBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), PictureAdapter.ListenerRecycler  {

    lateinit var binding: ActivityMainBinding
    private val adapter = PictureAdapter(this)
    var cContentOfView = ContentOfView()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bNavigator.selectedItemId = R.id.mainActivity
        binding.bNavigator.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mainActivity -> {

                }
                R.id.favoriteActivity -> {
                    val intent = Intent(this, FavoriteActivity::class.java)
                    startActivity(intent)
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
            ImageRecView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            ImageRecView.adapter = adapter
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