package com.example.bitirmeson.veritabani


import android.annotation.SuppressLint
import android.content.ContentValues

class verilerDAO {
    @SuppressLint("Range")
    fun  tumDemolar(vt:veritabani):ArrayList<Demolar>
    {
        val vt=vt.writableDatabase
        val demoList=ArrayList<Demolar>()
        val c=vt.rawQuery("SELECT * FROM Demolar",null)
        while (c.moveToNext()){
            val demo=Demolar(c.getInt(c.getColumnIndex("demoNo"))
                ,c.getString(c.getColumnIndex("demoAdi"))
                ,c.getInt(c.getColumnIndex("kareNo"))
                ,c.getInt(c.getColumnIndex("renk"))
                ,c.getString(c.getColumnIndex("entry"))
                ,c.getInt(c.getColumnIndex("time")))
            demoList.add(demo)
        }
        return demoList
    }
    fun demoSil(vt: veritabani, demoNo: Int, demoAdi: String, kareNo: Int) {
        val db = vt.writableDatabase
        val whereClause = "demoNo=? AND demoAdi=? AND kareNo=?"
        val whereArgs = arrayOf(demoNo.toString(), demoAdi, kareNo.toString())
        db.delete("Demolar", whereClause, whereArgs)
        db.close()
    }
    fun tumverileriSil(vt: veritabani, demoNo: Int, demoAdi: String) {
        val db = vt.writableDatabase
        val whereClause = "demoNo=? AND demoAdi=?"
        val whereArgs = arrayOf(demoNo.toString(), demoAdi)
        db.delete("Demolar", whereClause, whereArgs)
        db.close()
    }
    fun sonVeriyiSil(vt: veritabani) {
        val db = vt.writableDatabase
        val sql = "DELETE FROM demo_table WHERE id = (SELECT MAX(id) FROM demo_table)"
        db.execSQL(sql)
    }


    fun demoEkle(vt: veritabani, demoNo: Int, demoAdi:String, kareNo:Int, renk:Int,entry:String,time:Int){
        val vt=vt.writableDatabase
        val values= ContentValues()
        values.put("demoNo",demoNo)
        values.put("demoAdi",demoAdi)
        values.put("kareNo",kareNo)
        values.put("renk",renk)
        values.put("entry",entry)
        values.put("time",time)
        vt.insertOrThrow("Demolar",null,values)
        vt.close()
    }
    fun demoGuncelle(vt: veritabani,demoNo:Int,demoAdi: String){
        val vt=vt.writableDatabase
        val values= ContentValues()
        values.put("demoAdi",demoAdi)
        vt.update("Demolar",values,"demoNo=?", arrayOf(demoNo.toString()))
        vt.close()
    }
    @SuppressLint("Range")
    fun kayıtKontrol(vt:veritabani, demoAdi: String):Int{
        var sonuc=0
        val dbx=vt.writableDatabase
        val cursor=dbx.rawQuery("SELECT count(*) AS sonuc FROM Demolar WHERE demoAdi='$demoAdi'",null)
        while (cursor.moveToNext()){
            sonuc=cursor.getInt(cursor.getColumnIndex("sonuc"))
        }
        return sonuc
    }



}