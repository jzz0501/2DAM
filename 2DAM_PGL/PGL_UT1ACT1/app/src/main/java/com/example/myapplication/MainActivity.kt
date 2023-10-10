package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val provincias = ArrayAdapter.createFromResource(this@MainActivity, R.array.array, com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
        provincias.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val provincia_Spinner = binding.spinnerProvincia
        provincia_Spinner.adapter = provincias

        val dni_EditText = binding.editTextDni.text.toString()
        val name_EditText = binding.editTextNombre.text.toString()
        val apellido_EditText = binding.editTextApellido.text.toString()
        val correo_EditText = binding.editTextCorreo.text.toString()

        val residente_CheckBox = binding.checkBoxResidente

        val consultar_Button = binding.buttonConsultar
        val sobremi_Button = binding.buttonSobremi

        val provinciaResult = binding.resultProvincia

        val sexoGroup = binding.sexoGroup

        provincia_Spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                provinciaResult.text = "Has seleccionado ${parent!!.getItemAtPosition(position)}";
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        /*
        sexoGroup.setOnCheckedChangeListener { radioGroup, checkId ->
            when(checkId) {
                R.id.radioButton_masculino -> sexoResult.text = "Has seleccionado"
            }

        }
        */

    }
}