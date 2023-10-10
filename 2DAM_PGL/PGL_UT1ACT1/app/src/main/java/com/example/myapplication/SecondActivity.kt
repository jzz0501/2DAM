package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val bundle = intent.extras
        val name = bundle?.getString("name")
        val apellido = bundle?.getString("apellido")
        val correo = bundle?.getString("correo")
        val dni = bundle?.getString("dni")
        val isResidente = bundle?.getBoolean("residente")
    }
}