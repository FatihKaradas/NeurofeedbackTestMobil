package com.example.bitirmeson


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.EditText
import android.graphics.Color
import android.text.InputType
import android.view.Gravity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.bitirmeson.veritabani.verilerDAO
import com.example.bitirmeson.veritabani.veritabani
import com.example.bitirmeson.deneyListelemeSayfasi
import com.example.bitirmeson.veritabani.DemolarX
import com.example.bitirmeson.veritabani.verilerDAOX

class DemoOlusturmaSayfasi : AppCompatActivity() {
    private lateinit var vt: veritabani
    private var counter = 0
    private var sonButonTiklandiMi = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_olusturma_sayfasi)
        vt = veritabani(this)

        val editTextAdi = findViewById<EditText>(R.id.DemoAdi)
        val editTextNo = findViewById<EditText>(R.id.DemoNo)
        val createButton = findViewById<Button>(R.id.CreateButton)
        val deleteButton = findViewById<Button>(R.id.DeleteButton)
        val linearLayout = findViewById<LinearLayout>(R.id.Container)
        val buttonKirmizi = findViewById<Button>(R.id.KırmızıEkran)

        buttonKirmizi.setOnClickListener {
            if (counter < 0) {
                counter = 0
            }
            counter++
            sonButonTiklandiMi = false

            val squareLayout = LinearLayout(this)
            val layoutParams = LinearLayout.LayoutParams(500, 500)
            layoutParams.gravity = Gravity.CENTER_HORIZONTAL
            squareLayout.layoutParams = layoutParams
            squareLayout.orientation = LinearLayout.VERTICAL
            squareLayout.setBackgroundColor(Color.RED)
            linearLayout.addView(squareLayout)

            val editText = EditText(this)
            editText.setHintTextColor(Color.GRAY)
            editText.setTextColor(Color.WHITE)
            val editTextLayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            editTextLayoutParams.topMargin = 9
            editText.layoutParams = editTextLayoutParams
            editText.hint = "$counter.Command "
            squareLayout.addView(editText)

            val editText1 = EditText(this)
            editText1.inputType = InputType.TYPE_CLASS_NUMBER
            editText1.setHintTextColor(Color.GRAY)
            editText1.setTextColor(Color.WHITE)
            val editText1LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            editText1LayoutParams.topMargin = 9
            editText1.layoutParams = editText1LayoutParams
            editText1.hint = "$counter.Time(ms) "
            squareLayout.addView(editText1)

            val button = Button(this)
            button.text = "save"
            button.setTextColor(Color.WHITE)
            val buttonLayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            buttonLayoutParams.topMargin = 1
            button.layoutParams = buttonLayoutParams
            squareLayout.addView(button)

            button.setOnClickListener {
                sonButonTiklandiMi = true
                val entry = editText.text.toString().trim()
                val time = editText1.text.toString().trim()
                val demoNo = editTextNo.text.toString().trim()
                val demoAdi = editTextAdi.text.toString().trim()
                if (demoNo.isNotEmpty() && demoAdi.isNotEmpty() && entry.isNotEmpty() && time.isNotEmpty()) {
                    verilerDAO().demoEkle(vt, demoNo.toInt(), demoAdi, counter, 2, entry, time.toInt())
                } else {
                    Toast.makeText(this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val buttonYesil = findViewById<Button>(R.id.YesilEkran)
        buttonYesil.setOnClickListener {
            if (counter < 0) {
                counter = 0
            }
            counter++
            sonButonTiklandiMi = false

            val squareLayout = LinearLayout(this)
            val layoutParams = LinearLayout.LayoutParams(500, 500)
            layoutParams.gravity = Gravity.CENTER_HORIZONTAL
            squareLayout.layoutParams = layoutParams
            squareLayout.orientation = LinearLayout.VERTICAL
            squareLayout.setBackgroundColor(Color.GREEN)
            linearLayout.addView(squareLayout)

            val editText3 = EditText(this)
            editText3.setHintTextColor(Color.GRAY)
            editText3.setTextColor(Color.WHITE)
            val editText3LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            editText3LayoutParams.topMargin = 16
            editText3.layoutParams = editText3LayoutParams
            editText3.hint = "$counter.Command "
            squareLayout.addView(editText3)

            val editText4 = EditText(this)
            editText4.inputType = InputType.TYPE_CLASS_NUMBER
            editText4.setHintTextColor(Color.GRAY)
            editText4.setTextColor(Color.WHITE)
            val editText4LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            editText4LayoutParams.topMargin = 16
            editText4.layoutParams = editText4LayoutParams
            editText4.hint = "$counter.Time(ms) "
            squareLayout.addView(editText4)

            val button = Button(this)
            button.text = "save"
            button.setTextColor(Color.WHITE)
            val buttonLayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            buttonLayoutParams.topMargin = 1
            button.layoutParams = buttonLayoutParams
            squareLayout.addView(button)

            button.setOnClickListener {
                sonButonTiklandiMi = true
                val entry = editText3.text.toString().trim()
                val time = editText4.text.toString().trim()
                val demoNo = editTextNo.text.toString().trim()
                val demoAdi = editTextAdi.text.toString().trim()
                if (demoNo.isNotEmpty() && demoAdi.isNotEmpty() && entry.isNotEmpty() && time.isNotEmpty()) {
                    verilerDAO().demoEkle(vt, demoNo.toInt(), demoAdi, counter, 1, entry, time.toInt())
                } else {
                    Toast.makeText(this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show()
                }
            }
        }

        val buttonSiyah = findViewById<Button>(R.id.SiyahEkran)
        buttonSiyah.setOnClickListener {
            if (counter < 0) {
                counter = 0
            }
            counter++
            sonButonTiklandiMi = false

            val squareLayout = LinearLayout(this)
            val layoutParams = LinearLayout.LayoutParams(500, 500)
            layoutParams.gravity = Gravity.CENTER_HORIZONTAL
            squareLayout.layoutParams = layoutParams
            squareLayout.orientation = LinearLayout.VERTICAL
            squareLayout.setBackgroundColor(Color.BLACK)
            linearLayout.addView(squareLayout)

            val editText5 = EditText(this)
            editText5.inputType = InputType.TYPE_CLASS_NUMBER
            editText5.setHintTextColor(Color.WHITE)
            editText5.setTextColor(Color.WHITE)
            val editText5LayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            editText5LayoutParams.topMargin = 16
            editText5.layoutParams = editText5LayoutParams
            editText5.hint = "$counter.Time(ms) "
            squareLayout.addView(editText5)

            val textView = TextView(this)
            textView.text = "Stay Still"
            textView.setTextColor(Color.WHITE)
            val textViewLayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            textViewLayoutParams.topMargin = 16
            textView.layoutParams = textViewLayoutParams
            squareLayout.addView(textView)

            val button = Button(this)
            button.text = "save"
            button.setTextColor(Color.BLACK)
            val buttonLayoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            buttonLayoutParams.topMargin = 1
            button.layoutParams = buttonLayoutParams
            squareLayout.addView(button)

            button.setOnClickListener {
                sonButonTiklandiMi = true
                val time = editText5.text.toString().trim()
                val demoNo = editTextNo.text.toString().trim()
                val demoAdi = editTextAdi.text.toString().trim()
                if (demoNo.isNotEmpty() && demoAdi.isNotEmpty() && time.isNotEmpty()) {
                    verilerDAO().demoEkle(vt, demoNo.toInt(), demoAdi, counter, 3, "Stay Still", time.toInt())
                } else {
                    Toast.makeText(this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show()
                }
            }
        }

        deleteButton.setOnClickListener {
            val lastIndex = linearLayout.childCount - 1
            if (lastIndex >= 0) {
                linearLayout.removeViewAt(lastIndex)
                if (sonButonTiklandiMi) {
                    // Son eklenen veriyi silmek için gerekli bilgileri alın
                    val demoNo = editTextNo.text.toString().toInt()
                    val demoAdi = editTextAdi.text.toString()
                    // Veritabanından son kaydı silmek için demoSil fonksiyonunu çağırın
                    verilerDAO().demoSil(vt,demoNo,demoAdi,counter)
                    sonButonTiklandiMi = false
                }
            }
            counter--
            if (counter < 0) {
                counter = 0
            }
        }


        createButton.setOnClickListener {
            val demoNo = editTextNo.text.toString().trim()
            val demoAdi = editTextAdi.text.toString().trim()
            if (demoNo.isNotEmpty() && demoAdi.isNotEmpty()) {
                verilerDAOX().demoEkle(vt, demoNo.toInt(), demoAdi)
            }
            val intent = Intent(this, deneyListelemeSayfasi::class.java)
            startActivity(intent)
        }
    }
}