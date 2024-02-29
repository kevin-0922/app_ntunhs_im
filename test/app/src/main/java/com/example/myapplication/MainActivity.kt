package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView = findViewById<TextView>(R.id.textView)
        val result_textView = findViewById<TextView>(R.id.result_textView)
        val guess_button = findViewById<Button>(R.id.guess_button)
        val reset_button = findViewById<Button>(R.id.reset_button)
        val editText = findViewById<EditText>(R.id.editText)
        var validate_num:Int
        var secret : Int = Random().nextInt(50)+1

        guess_button.setOnClickListener {

            //Toast.makeText(this,editText.text,Toast.LENGTH_LONG).show()
            //AlertDialog.Builder(this).setTitle("onclick").setMessage("onclick").create().show()
            textView.text = editText.text
            validate_num = editText.text.toString().toInt()-secret
            var ans_str :String="你猜對了"

            if(validate_num > 0){
                ans_str="你猜的比較大喔"
            }else if(validate_num < 0){
                ans_str="你猜的比較小喔"
            }
            textView.text=ans_str
        }

        reset_button.setOnClickListener {
            secret = Random().nextInt(50) + 1
            textView.text = "我們在猜一次"

        }
    }
}