package com.example.databindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.databindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //variable name: datatype = Data class
        val s:Student = Student("W123456", "Ali")
        binding.student = s

        val s2:Student = Student("W654321", "Abu")
//        binding.tvStudentID.text = s.id
//        binding.tvStudentName.text = s.name

//        binding.tvStudentID.text = "W123456"
//        binding.tvStudentName.text = "Ali"
        binding.btnUpdate.setOnClickListener(){
            s.name = "Alex"

            binding.apply {
                invalidateAll()
            }
        }
    }
}