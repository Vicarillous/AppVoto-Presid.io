package com.example.appvoto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class CadastroAvancado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_avancando)

        Log.i("Idade", Pessoa.calcDate().toString())

        val btnContinuar = findViewById<Button>(R.id.button)
        val btnPular = findViewById<TextView>(R.id.textViewPular)
        val irParaCadastroFinal = Intent(this, CadastroFinal::class.java)

        btnContinuar.setOnClickListener {
            startActivity(irParaCadastroFinal)
        }

        btnPular.setOnClickListener {
            startActivity(irParaCadastroFinal)
        }
    }
}