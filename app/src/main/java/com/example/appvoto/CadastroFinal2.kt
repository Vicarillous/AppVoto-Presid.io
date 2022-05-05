package com.example.appvoto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CadastroFinal2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_final2)

        val btnVamosLa = findViewById<Button>(R.id.button)
        val btnPular = findViewById<TextView>(R.id.textViewPular)

        btnVamosLa.setOnClickListener {
            mostrarPaginaResultado()
        }

        btnPular.setOnClickListener {
            mostrarPaginaResultado()
        }
    }

    private fun mostrarPaginaResultado() {
        when (val idade = Pessoa.calcDate()) {
            in 18..Long.MAX_VALUE -> { // 18 anos ou mais
                val irParaDeveVotar = Intent(this, DeveVotar::class.java)
                startActivity(irParaDeveVotar)
            }
            in 16..17 -> { // 16 a 17 anos
                val irParaPodeVotar = Intent(this, PodeVotar::class.java)
                startActivity(irParaPodeVotar)
            }
            else -> { // menos de 16 anos
                val irParaNaoVota = Intent(this, NaoVota::class.java)
                irParaNaoVota.putExtra("idade", idade)
                startActivity(irParaNaoVota)
            }
        }
    }
}