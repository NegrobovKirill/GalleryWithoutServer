package com.example.gallery.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.example.gallery.MainActivity
import com.example.gallery.R

class SplashScreenActivity : AppCompatActivity() {
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        val backgroundImg: ImageView = findViewById(R.id.splash_image_id)
        val appearAnimation = AnimationUtils.loadAnimation(this, R.anim.myalpha)
        backgroundImg.startAnimation(appearAnimation)

        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },1500)
    }



}