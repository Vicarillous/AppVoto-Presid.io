package com.example.appvoto

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class NaoVota : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nao_vota)

        mostrarIdadeRestante()
    }

    @SuppressLint("SetTextI18n")
    private fun mostrarIdadeRestante() {
        val bundle = intent.extras
        var idadeRestante = 0

        if (bundle != null) {
            idadeRestante = intent.getLongExtra("idade", 0).toInt()
            idadeRestante = 16 - idadeRestante
        }

        val naoVotaTexto = findViewById<TextView>(R.id.nao_vota_text)

        naoVotaTexto.text =
            "Infelizmente você ainda não pode votar, espere $idadeRestante ${if (idadeRestante == 1) "ano" else "anos"} e você estará apto para isso."
    }
}