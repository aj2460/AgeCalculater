package com.example.calculateage

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calculateage.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        //val myButton= findViewById<Button>(R.id.btnDatePicker)
      //  myButton.setOnClickListener { Toast.makeText(this,"Button Works",Toast.LENGTH_LONG).show() }

        binding.btnDatePicker.setOnClickListener {view->
            clickDatePicker(view)
            //Toast.makeText(this,"Button Works",Toast.LENGTH_LONG).show()
         }

    }

    fun clickDatePicker(view: View){
    val myCalendar= Calendar.getInstance()
        val year=myCalendar.get(Calendar.YEAR)
        val month=myCalendar.get(Calendar.MONTH)
        val day=myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
        DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            binding.tvSelectedDate.text="$dayOfMonth/${month+1}/$year"
            val date="$dayOfMonth/${month+1}/$year"
            val sdf=SimpleDateFormat("dd/MM/yyyy")
            val theDate=sdf.parse(date)
            val millionSeconds = Calendar.getInstance().timeInMillis - theDate.time
            binding.tvAgeInMin.text = java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(millionSeconds).toString()
        },year,month,day).show()

    }

}