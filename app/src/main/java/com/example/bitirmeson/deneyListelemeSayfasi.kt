package com.example.bitirmeson


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitirmeson.RVadapter.adapter
import com.example.bitirmeson.veritabani.Demolar
import com.example.bitirmeson.veritabani.DemolarX
import com.example.bitirmeson.veritabani.veritabani
import com.example.bitirmeson.veritabani.verilerDAO
import com.example.bitirmeson.veritabani.verilerDAOX

    class deneyListelemeSayfasi : AppCompatActivity() {
        private lateinit var vt:veritabani
        private lateinit var demolarList:ArrayList<Demolar>
        private lateinit var demolarListX:ArrayList<DemolarX>
        private lateinit var adapter: adapter
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_deney_listeleme_sayfasi)
            val layoutManager = LinearLayoutManager(this)
            val recyclerView=findViewById<RecyclerView>(R.id.rv)
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = layoutManager
            val button=findViewById<ImageView>(R.id.eklebuton)
            button.setOnClickListener{
                val intent= Intent(this,DemoOlusturmaSayfasi::class.java)
                startActivity(intent)
            }
            vt=veritabani(this)
            demolarList=verilerDAO().tumDemolar(vt)
            demolarListX=verilerDAOX().tumDemolar(vt)
            adapter=adapter(this,demolarListX)
            recyclerView.adapter=adapter
        val veriler = verilerDAO().tumDemolar(vt)
        for (veri in veriler) {
            // Verileri loglama veya ekrana yazdırma
            Log.d("VeriTeyidi", "Demo No: ${veri.demoNo}, Demo Adı: ${veri.demoAdi}" +
                    ", Kare No: ${veri.kareNo}, Renk: ${veri.renk}, Entry: ${veri.entry}, Time: ${veri.time}")
        }
    } }