package com.example.appvoto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CadastroBasico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_basico)

        var dateInput = findViewById<EditText>(R.id.editTextNasc)
        val btnContinuar = findViewById<Button>(R.id.button)
        val irParaCadastroAvancado = Intent(this, CadastroAvancado::class.java)

        dateInput.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if(dateInput.length() >= 11) {
                    val length = dateInput.length()
                    dateInput.text.delete(length - 1, length)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                Log.i("Texto", "Texto: $s")
                Log.i("Texto", "Start: $start")
                Log.i("Texto", "Before: $before")
                Log.i("Texto", "Count: $count")
                Log.i("Texto", "---------------------------------")
                if(count != 0) {
                    if(s.length == 2 || s.length == 5) {
                        dateInput.append("/")
                    }
                }
            }
        })

        btnContinuar.setOnClickListener {
            val nascimento = dateInput.text.toString()

            nascimento.takeIf { it.isEmpty() || it.length < 10 }?.let {
                Log.i("Data","Data de nascimento necessária!")
                Toast.makeText(applicationContext, "Data de nascimento necessária!", Toast.LENGTH_SHORT).show()
            } ?: run {
                Pessoa.setDataNasc(nascimento)
                startActivity(irParaCadastroAvancado)
            }
        }
    }
}