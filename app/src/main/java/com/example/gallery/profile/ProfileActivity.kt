package com.example.gallery.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gallery.favorite.FavoriteActivity
import com.example.gallery.MainActivity
import com.example.gallery.R
import com.example.gallery.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity()  {
    lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bNavigator.selectedItemId = R.id.profileActivity
        binding.bNavigator.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mainActivity -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.favoriteActivity -> {
                    val intent = Intent(this, FavoriteActivity::class.java)
                    startActivity(intent)
                }
                R.id.profileActivity -> {

                }
            }
            true
        }

    }
}


