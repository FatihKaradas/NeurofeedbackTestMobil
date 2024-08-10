package com.example.bitirmeson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.collections.HashSet

private lateinit var skor:TextView
private lateinit var StartButton:Button
private lateinit var squareImageView0:ImageView
private lateinit var squareImageView1:ImageView
private lateinit var squareImageView2:ImageView
private lateinit var squareImageView3:ImageView
private lateinit var squareImageView4:ImageView
private lateinit var squareImageView5:ImageView
private lateinit var squareImageView6:ImageView
private lateinit var squareImageView7:ImageView
private lateinit var squareImageView8:ImageView
private var stepCount=0
private var counter1=0
private var counter:Float=0.0f
class Dual2Back : AppCompatActivity() {
    private val squareImageViews = arrayOfNulls<ImageView>(9)
    private val numbers = intArrayOf(0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dual2_back)
        squareImageViews[0] = findViewById(R.id.squareImageView0)
        squareImageViews[1] = findViewById(R.id.squareImageView1)
        squareImageViews[2] = findViewById(R.id.squareImageView2)
        squareImageViews[3] = findViewById(R.id.squareImageView3)
        squareImageViews[4] = findViewById(R.id.squareImageView4)
        squareImageViews[5] = findViewById(R.id.squareImageView5)
        squareImageViews[6] = findViewById(R.id.squareImageView6)
        squareImageViews[7] = findViewById(R.id.squareImageView7)
        squareImageViews[8] = findViewById(R.id.squareImageView8)
        skor=findViewById<TextView>(R.id.skor)
        StartButton=findViewById<Button>(R.id.StartButton)
        StartButton.setOnClickListener{
            startGame()
        }
    }
    private fun startGame() {
        counter=0.00f
        counter1=0
        skor.text="Success Rate:"
        stepCount = 0
        showNextStep()
    }
    private val randomNumbersList = mutableListOf<Int>()
    private var twoStepsAgoNumber: Int? = null
    private val twoStepAgoNumberList = mutableListOf<Int>()
    private fun showNextStep() {
        if (stepCount < 10) {
            val randomIndex = Random().nextInt(9)
            randomNumbersList.add(randomIndex) // Rastgele sayıyı listeye ekle
            val selectedImageView = squareImageViews[randomIndex]!!
            selectedImageView?.setImageResource(getDrawableResource(1))
            // İki tur önceki rakamı belirle
            if (stepCount >= 2) {
                twoStepsAgoNumber = randomNumbersList[stepCount - 2]
                twoStepAgoNumberList.add(twoStepsAgoNumber!!)
                val selectedtwostepagoImageView=squareImageViews[twoStepsAgoNumber!!]
                selectedtwostepagoImageView?.setOnClickListener{
                    counter1++
                    Toast.makeText(applicationContext,"Correct Match",Toast.LENGTH_SHORT).show()
                } }
            Handler(Looper.getMainLooper()).postDelayed({
                selectedImageView.setImageResource(0)
                stepCount++
                showNextStep()
            }, 1500)
        } else {
            Log.d("RandomNumbers", randomNumbersList.joinToString(", "))
            Log.d("TwoStepAgoNumbers", twoStepAgoNumberList.joinToString(", "))
            counter= ((counter1.toFloat()/8)*100)
            skor.text = "Success Rate:%${counter}"
            randomNumbersList.clear() // Listeyi temizle
            twoStepAgoNumberList.clear() } }

    private fun getDrawableResource(number: Int): Int {
        return when (number) {
            1 -> R.drawable.turuncu
            else -> R.drawable.turuncu // Default
        }
    }
    private fun getRandomItem(array: IntArray): Int {
        val random = Random()
        return array[random.nextInt(array.size)]
    }



}