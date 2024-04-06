package com.example.router

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        var txttext = findViewById<TextView>(R.id.txttext)
        var btnBacktoFirst = findViewById<Button>(R.id.btnBacktoFirst)
        val text = intent.getBundleExtra("key")?.getString("name").toString()



        txttext.setText(text)

        btnBacktoFirst.setOnClickListener {
            finish()
        }
    }
    var lastTime: Long = 0
    override  fun finish(){
        val currenTime = System.currentTimeMillis()
        if (currenTime-lastTime>3*1000){
            lastTime = currenTime
            Toast.makeText(this,"再按一下離開", Toast.LENGTH_SHORT).show()
        }else{
            super.finish()
        }
    }
}