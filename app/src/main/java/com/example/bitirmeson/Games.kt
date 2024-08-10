package com.example.bitirmeson

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Games : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)
        val imagedual2backgecis = findViewById<ImageView>(R.id.imageView)
        imagedual2backgecis.setOnClickListener{
            val intent = Intent(this,Dual2Back::class.java)
            startActivity(intent)
        }
        val imagereactiontimegecis = findViewById<ImageView>(R.id.imageView2)
        imagereactiontimegecis.setOnClickListener{
            val intent = Intent(this,ReactionTime::class.java)
            startActivity(intent)
        }
     }
    }
