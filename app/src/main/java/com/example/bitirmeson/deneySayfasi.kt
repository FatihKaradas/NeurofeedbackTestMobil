package com.example.bitirmeson

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isInvisible
import com.example.bitirmeson.RVadapter.adapter
import com.example.bitirmeson.veritabani.Demolar
import com.example.bitirmeson.veritabani.DemolarX
import com.example.bitirmeson.veritabani.veritabani
import com.example.bitirmeson.veritabani.verilerDAO
import com.example.bitirmeson.veritabani.verilerDAOX
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class deneySayfasi : AppCompatActivity() {
    private lateinit var vt: veritabani
    private lateinit var demolarList: ArrayList<Demolar>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deney_sayfasi)

        // Veritabanını başlatma
        vt = veritabani(this)

        val text = findViewById<TextView>(R.id.textView)
        val ekran = findViewById<ConstraintLayout>(R.id.ekranrengi)
        val text2 = findViewById<TextView>(R.id.textdeneytext)
        val butondeneyibitir = findViewById<Button>(R.id.butondeneyibitir)
        val butondeneyibaslat = findViewById<Button>(R.id.butondeneyebasla)
        val deneyibitirtext = findViewById<TextView>(R.id.deneyibitirtext)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        // Intent'ten demo numarasını al
        val demoNumarasi = intent.getIntExtra("demo", -1)

        // Veritabanından ilgili demoları al
        val veriler = verilerDAO().tumDemolar(vt)

        // Demo numarasına göre filtrele
        val ilgiliVeriler = veriler.filter { it.demoNo == demoNumarasi }

        // Coroutine başlatma
        butondeneyibaslat.setOnClickListener{
            butondeneyibaslat.visibility= View.INVISIBLE
            text2.visibility=View.INVISIBLE
            progressBar.visibility = View.VISIBLE
            CoroutineScope(Dispatchers.Main).launch {
                for (veri in ilgiliVeriler) {
                    // Renk ayarı
                    when (veri.renk) {
                        1 -> ekran.setBackgroundColor(Color.GREEN)
                        2 -> ekran.setBackgroundColor(Color.RED)
                        3 -> ekran.setBackgroundColor(Color.BLACK)
                        else -> ekran.setBackgroundColor(Color.WHITE)
                    }

                    // TextView ayarı
                    text.text = veri.entry

                    for (i in 0..100) {
                        progressBar.progress = i
                        delay(veri.time.toLong() / 100) // Delay'i bölerek animasyon sağlama
                    }
                }

                // For döngüsü tamamlandıktan sonra MainActivity'e geçiş yap
                progressBar.visibility = View.INVISIBLE
                text.text =""
                ekran.setBackgroundColor(Color.BLACK)
                butondeneyibitir.visibility=View.VISIBLE
                deneyibitirtext.visibility=View.VISIBLE
                butondeneyibitir.setOnClickListener {
                    val intent = Intent(this@deneySayfasi, deneyListelemeSayfasi::class.java)
                    startActivity(intent)
                    finish() // Bu aktiviteyi bitir
                }
            }}
    }
}
