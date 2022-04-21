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
        btnVamosLa.setOnClickListener {
            val idade = Pessoa.calcDate();

            if(idade >= 18){
                val irParaDeveVotar = Intent(this, DeveVotar::class.java)
                startActivity(irParaDeveVotar)
            }else if (idade in 16..17){
                val irParaPodeVotar = Intent(this, PodeVotar::class.java)
                startActivity(irParaPodeVotar)
            } else {
                val irParaNaoVota = Intent(this, NaoVota::class.java)
                startActivity(irParaNaoVota)
            }
        }

    }
}