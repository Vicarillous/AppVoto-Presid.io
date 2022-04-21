package com.example.appvoto

import java.text.SimpleDateFormat
import java.util.*

class Pessoa {
    fun calcDate() {
        val dataNasc = SimpleDateFormat("dd/MM/yyyy")
        val dataAtual = SimpleDateFormat("dd/MM/yyyy")
        val dataNascimento = dataNasc.parse("01/01/2000")
        val dataAtualizada = Calendar.getInstance().time
        val diferenca = dataAtualizada.time - dataNascimento.time
        val dias = diferenca / (1000 * 60 * 60 * 24)
        val idade = dias / 365
    }
}