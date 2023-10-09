package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val provincias = ArrayAdapter.createFromResource(this@MainActivity, R.array.array, com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
        provincias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        
    }
}