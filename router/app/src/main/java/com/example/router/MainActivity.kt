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


        val  btnChangeActivity = findViewById<Button>(R.id.btnChangeActivity)
        val  btnOpenBrowser = findViewById<Button>(R.id.btnOpenBrowser)
        val  edtName = findViewById<EditText>(R.id.edtName)


        btnChangeActivity.setOnClickListener{
            var  bundle = Bundle()
            var name = edtName.text.toString()
            bundle.putString("name",name)

            var seconIntent = Intent(this,SecondActivity::class.java)
            seconIntent.putExtra("key",bundle)
            startActivity(seconIntent)
        }
        btnOpenBrowser.setOnClickListener{
            var seconIntent =  Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(seconIntent)
        }
    }
}