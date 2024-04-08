package com.example.router

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnChangeActivity = findViewById<Button>(R.id.btnChangeActivity)
        val btnOpenBrowser = findViewById<Button>(R.id.btnOpenBrowser)

        btnChangeActivity.setOnClickListener {
            // 創建一個 Intent 來啟動 Rock_paper_scissors 活動
            val intent = Intent(this, Rock_papaer_scissors::class.java)
            // 啟動指定的活動，不傳遞任何數據
            startActivity(intent)
        }

        btnOpenBrowser.setOnClickListener {
            // 創建一個 Intent 來啟動 Rock_paper_scissors 活動
            val intent = Intent(this, guess_number::class.java)
            // 啟動指定的活動，不傳遞任何數據
            startActivity(intent)
        }


    }
}
