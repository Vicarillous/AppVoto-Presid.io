package com.example.appvoto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CadastroFinal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_final)

        val btnContinuar = findViewById<Button>(R.id.button)
        val btnPular = findViewById<TextView>(R.id.textViewPular)
        val irParaCadastroFinal2 = Intent(this, CadastroFinal2::class.java)

        btnContinuar.setOnClickListener {
            startActivity(irParaCadastroFinal2)
        }

        btnPular.setOnClickListener {
            startActivity(irParaCadastroFinal2)
        }
    }
}