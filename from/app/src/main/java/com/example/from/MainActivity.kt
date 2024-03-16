package com.example.from

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import org.w3c.dom.Text
import java.time.Month
import java.time.Year
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spnCity = findViewById<Spinner>(R.id.spnCity)
        val adapter = ArrayAdapter.createFromResource(
            this, R.array.city,
            android.R.layout.simple_spinner_dropdown_item
        )
        val RadGroup_Gender = findViewById<RadioGroup>(R.id.RadGroup_Gender)
        val Radbtn_man = findViewById<RadioButton>(R.id.RadBtn_man)
        val Radbtn_woman = findViewById<RadioButton>(R.id.RadBtn_woman)
        val ChB_Pingpong = findViewById<CheckBox>(R.id.ChB_Pingpong)
        val ChB_Badminton = findViewById<CheckBox>(R.id.ChB_Badminton)
        val ChB_Swim = findViewById<CheckBox>(R.id.ChB_Swim)
        var Btn_Send = findViewById<Button>(R.id.Btn_send)
        var Text_BD = findViewById<EditText>(R.id.Text_BD)
        var Text_Phone = findViewById<EditText>(R.id.Text_Phone)
        var Text_Account = findViewById<EditText>(R.id.Text_Account)
        var Text_Password = findViewById<EditText>(R.id.Text_Password)
        var Text_Email = findViewById<EditText>(R.id.Text_Email)
        var Text_Name = findViewById<EditText>(R.id.Text_Name)
        var View_Name = findViewById<TextView>(R.id.View_Name)
        var View_Account = findViewById<TextView>(R.id.View_Account)
        var View_BD = findViewById<TextView>(R.id.View_BD)
        var View_Email = findViewById<TextView>(R.id.View_Email)
        var View_Gender = findViewById<TextView>(R.id.View_Gender)
        var View_Password = findViewById<TextView>(R.id.View_PassWord)
        var View_Vehicle = findViewById<TextView>(R.id.View_Vehicle)

        //夏拉選單監聽
        spnCity.adapter = adapter
        spnCity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


        Text_BD.setOnClickListener{
            val calender = Calendar.getInstance()
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val day = calender.get(Calendar.DAY_OF_MONTH)
            DatePickerDialog(this,{_, year, month , day ->
                run{
                    var format = "${setDateFormat(year,month,day)}"
                    Text_BD.setText(format)
                }
            }, year, month , day).show()
        }


        //設定listener
        var gender:String=""
        RadGroup_Gender.setOnCheckedChangeListener { _, checkedId ->
            gender = when (checkedId) {
                R.id.RadBtn_man -> Radbtn_man.text.toString()
                R.id.RadBtn_woman -> Radbtn_woman.text.toString()
                else -> "I don't Know"
            }

            /*Toast.makeText(this, gender, Toast.LENGTH_SHORT).show()*/
        }


        Btn_Send.setOnClickListener{
            var msgChB = ""
            if (ChB_Pingpong.isChecked()){
                msgChB = msgChB +" "+ ChB_Pingpong.getText().toString()
            }
            if (ChB_Badminton.isChecked()){
                msgChB = msgChB +" "+ ChB_Badminton.getText().toString()
            }
            if (ChB_Swim.isChecked()){
                msgChB = msgChB +" "+ ChB_Swim.getText().toString()
            }

            var msg = ""
            msg += "${View_Account.text }"+"${Text_Account.text}"+"\n"
            msg += "${View_Password.text }"+"${Text_Password.text}"+"\n"
            msg += "${View_Name.text }"+"${Text_Name.text}"+"\n"
            msg += "${View_Email.text }"+"${Text_Email.text}"+"\n"
            msg += "${View_BD.text }"+"${Text_BD.text}"+"\n"
            msg += "電話：" + Text_Phone.text.toString() + "\n"
            msg += "居住地："+spnCity.getSelectedItem().toString()+"\n"
            msg += "${View_Gender.text}"+gender+"\n"
            msg += "${View_Vehicle.text}"+ msgChB


            AlertDialog.Builder(this)
                .setTitle("送出確認")
                .setMessage(msg)
                .create()
                .show()
        }
    }
    private fun setDateFormat(year: Int,month: Int,day:Int):String{
        return "$year-${month + 1}-$day"
    }
}
