package com.example.bitirmeson.RVadapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.bitirmeson.R
import com.example.bitirmeson.deneySayfasi
import com.example.bitirmeson.veritabani.DemolarX
import com.example.bitirmeson.veritabani.verilerDAO
import com.example.bitirmeson.veritabani.verilerDAOX
import com.example.bitirmeson.veritabani.veritabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class adapter(private val mContext: Context, private val demolarList: ArrayList<DemolarX>)
    :RecyclerView.Adapter<adapter.CardTasarimTutucu>(){
    inner class CardTasarimTutucu(tasarim:View):RecyclerView.ViewHolder(tasarim){
        var cardtasarim:CardView
        var satirYazi:TextView
        var satirNum:TextView
        var satirResim:ImageView
        init {
            cardtasarim=tasarim.findViewById(R.id.cardtasarim)
            satirYazi=tasarim.findViewById(R.id.satirYazi)
            satirNum=tasarim.findViewById(R.id.satirNum)
            satirResim=tasarim.findViewById(R.id.satirResim)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim=LayoutInflater.from(mContext).inflate(R.layout.cardtasarim,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun getItemCount(): Int {
        return demolarList.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val demo=demolarList.get(position)
        holder.satirYazi.text=demo.demoAdi
        holder.satirNum.text=(demo.demoNo).toString()
        holder.satirResim.setOnClickListener{
            //3lü bara tıklandığında ne olacağını kodlayacağımız alan
            val menu=PopupMenu(mContext,holder.satirResim)
            menu.menuInflater.inflate(R.menu.menu1,menu.menu)
            menu.show()
            menu.setOnMenuItemClickListener {
                    item->when(item.itemId){
                R.id.action_baslat->{
                    val intent= Intent(mContext,deneySayfasi::class.java)
                    intent.putExtra("demo",demo.demoNo)
                    mContext.startActivity(intent)
                    true }
                R.id.action_sil->{
                    CoroutineScope(Dispatchers.IO).launch {
                        val vt = veritabani(mContext)
                        verilerDAO().tumverileriSil(vt,demo.demoNo,demo.demoAdi)
                        verilerDAOX().demoSil(vt,demo.demoNo)
                        // UI güncelleme işlemleri ana thread'de yapılmalıdır
                        CoroutineScope(Dispatchers.Main).launch {
                            demolarList.removeAt(position)
                            notifyItemRemoved(position)
                            notifyItemRangeChanged(position, itemCount) } }
                    true }
                else->false } } }
        holder.cardtasarim.setOnClickListener{
            val intent= Intent(mContext,deneySayfasi::class.java)
            intent.putExtra("demo",demo.demoNo)
            mContext.startActivity(intent) } } }