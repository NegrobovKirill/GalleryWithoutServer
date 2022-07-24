package com.example.gallery.contain

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.gallery.MainActivity
import com.example.gallery.R
import com.example.gallery.databinding.ActivityContaintBinding
import com.example.gallery.picture.Picture

class ContaintActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContaintBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContaintBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item = intent.getSerializableExtra("item") as Picture
        binding.apply {
            imageCon.setImageResource(item.imageId)
            titlePicture.text = item.title
            textCon.text = item.discription
            textData.text = item.addTime
        }




        val MainActivityBtn: Button = findViewById(R.id.buttonVector)
        MainActivityBtn.setOnClickListener() {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}

