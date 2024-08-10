package com.example.bitirmeson

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class ReactionTime : AppCompatActivity() {
    private lateinit var startButton: Button
    private lateinit var scoreTextView: TextView
    private lateinit var mainLayout: View
    private var startTime: Long = 0
    private var endTime: Long = 0
    private var isGameRunning: Boolean = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reaction_time)

        startButton = findViewById(R.id.startButton)
        scoreTextView = findViewById(R.id.scoreTextView)
        mainLayout = findViewById(R.id.mainLayout)

        startButton.setOnClickListener {
            if (!isGameRunning) {
                startGame()
            }
        }
        mainLayout.setOnClickListener {
            if (isGameRunning && mainLayout.isClickable) {
                endGame()
            }
        }
        // Başlangıç ekranını kırmızı yap
        mainLayout.setBackgroundColor(Color.RED)
    }

    private fun startGame() {
        startButton.isEnabled=false
        isGameRunning = true
        scoreTextView.text = "Score: 0"
        mainLayout.setBackgroundColor(Color.RED)
        val random = Random()
        val randomDelay = (5 + random.nextInt(6)) * 1000L  // 5-10 saniye arası

        Handler(Looper.getMainLooper()).postDelayed({
            if (isGameRunning) {
                mainLayout.setBackgroundColor(Color.GREEN)
                startTime = System.currentTimeMillis()
                mainLayout.isClickable = true
            }
        }, randomDelay)
    }

    private fun endGame() {
        startButton.isEnabled=true
        isGameRunning = false
        endTime = System.currentTimeMillis()
        val elapsedTime = endTime - startTime
        mainLayout.isClickable = false
        mainLayout.setBackgroundColor(Color.RED)
        scoreTextView.text = "Score: ${elapsedTime}ms"
    }
}