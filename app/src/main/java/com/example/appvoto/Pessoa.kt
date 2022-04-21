package com.example.appvoto

import java.text.SimpleDateFormat

class Pessoa {
    fun calcDate() {
        val dataNasc = SimpleDateFormat("dd/MM/yyyy")
        val dataAtual = SimpleDateFormat("dd/MM/yyyy")
        val dataNascimento = dataNasc.parse("01/01/2000")
        val dataAtualizada = dataAtual.parse("01/01/2020")
        val diferenca = dataAtualizada.time - dataNascimento.time
        val dias = diferenca / (1000 * 60 * 60 * 24)
        val idade = dias / 365
    }
}