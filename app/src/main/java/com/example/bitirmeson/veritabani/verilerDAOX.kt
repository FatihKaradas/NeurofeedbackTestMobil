package com.example.bitirmeson.veritabani


import android.annotation.SuppressLint
import android.content.ContentValues

class verilerDAOX {
    @SuppressLint("Range")
    fun  tumDemolar(vt:veritabani):ArrayList<DemolarX>
    {
        val vt=vt.writableDatabase
        val demoListX=ArrayList<DemolarX>()
        val c=vt.rawQuery("SELECT * FROM DemolarX",null)
        while (c.moveToNext()){
            val demoX=DemolarX(c.getInt(c.getColumnIndex("demoNo"))
                ,c.getString(c.getColumnIndex("demoAdi")))
            demoListX.add(demoX)
        }
        return demoListX
    }
    fun demoSil(vt: veritabani,demoNo:Int){
        val vt=vt.writableDatabase
        vt.delete("DemolarX","demoNo=?", arrayOf(demoNo.toString()))
        vt.close()
    }
    fun demoEkle(vt: veritabani, demoNo: Int, demoAdi:String){
        val vt=vt.writableDatabase
        val values= ContentValues()
        values.put("demoNo",demoNo)
        values.put("demoAdi",demoAdi)
        vt.insertOrThrow("DemolarX",null,values)
        vt.close()
    }
    fun demoGuncelle(vt: veritabani,demoNo:Int,demoAdi: String){
        val vt=vt.writableDatabase
        val values= ContentValues()
        values.put("demoAdi",demoAdi)
        vt.update("DemolarX",values,"demoNo=?", arrayOf(demoNo.toString()))
        vt.close()
    }
    @SuppressLint("Range")
    fun kayıtKontrol(vt:veritabani, demoAdi: String):Int{
        var sonuc=0
        val dbx=vt.writableDatabase
        val cursor=dbx.rawQuery("SELECT count(*) AS sonuc FROM DemolarX WHERE demoAdi='$demoAdi'",null)
        while (cursor.moveToNext()){
            sonuc=cursor.getInt(cursor.getColumnIndex("sonuc"))
        }
        return sonuc
    }

}