package com.example.bitirmeson.veritabani


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class veritabani(context: Context):SQLiteOpenHelper(context,"Demolar.sqlite",null,4) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Demolar( demoNo INTEGER ,demoAdi TEXT,kareNo INTEGER, renk INTEGER,entry TEXT,time INTEGER);")
        db?.execSQL("CREATE TABLE DemolarX( demoNo INTEGER ,demoAdi TEXT);")

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS Demolar")
        db?.execSQL("DROP TABLE IF EXISTS DemolarX")
        onCreate(db)
    }

}