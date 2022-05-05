package com.example.appvoto

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PodeVotar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pode_votar)

        val btnSaibaMais = findViewById<Button>(R.id.button)

        btnSaibaMais.setOnClickListener {
            val uri =  Uri.parse("https://www.tse.jus.br/eleitor/titulo-de-eleitor")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }


    }
}