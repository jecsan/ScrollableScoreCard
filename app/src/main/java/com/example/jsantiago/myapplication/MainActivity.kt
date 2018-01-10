package com.example.jsantiago.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.adapter = ScoreCardAdapter()
        recycler.setItemViewCacheSize(100)
        recycler.addItemDecoration(object : RecyclerView.ItemDecoration() {

        })



    }
}
