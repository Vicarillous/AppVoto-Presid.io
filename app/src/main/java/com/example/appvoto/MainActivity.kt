package com.example.appvoto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnComecar = findViewById<Button>(R.id.button)
        val irParaCadastroBasico = Intent(this, CadastroBasico::class.java)

        btnComecar.setOnClickListener {
            startActivity(irParaCadastroBasico)
        }
    }
}