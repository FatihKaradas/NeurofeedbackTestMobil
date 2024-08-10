package com.example.bitirmeson


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gifImageView: ImageView = findViewById(R.id.my_gif)
        Glide.with(this).asGif().load(R.drawable.animasyon).into(gifImageView)
        val butonDemos = findViewById<Button>(R.id.button2)
        val butonGames = findViewById<Button>(R.id.button)
        butonDemos.setOnClickListener{
        val intent = Intent(this@MainActivity, deneyListelemeSayfasi::class.java)
        startActivity(intent)}
        butonGames.setOnClickListener{
            val intent =Intent(this@MainActivity,Games::class.java)
            startActivity(intent)
        }
    }
}