package com.example.appvoto

import java.text.SimpleDateFormat
import java.util.*

class Pessoa {

    companion object {
        // Em kotlin, não é necessário criar os métodos get e set, pois são criados automaticamente pela linguagem Kotlin
        // Caso não queira criar os métodos get e set, basta colocar o modificador de acesso private

        var dataNasc: String = ""
        var idade: Long = 0
            private set // nesse caso, o método set não será criado automaticamente, mas o método get será criado automaticamente

        fun calcDate(): Long { //calcula a idade
            val dataNascimento = SimpleDateFormat("dd/MM/yyyy").parse(dataNasc) //transforma a data de nascimento em Date
            val dataAtualizada = Calendar.getInstance().time //pega a data atual
            val diferenca = dataAtualizada.time - dataNascimento.time //calcula a diferença entre as datas
            val dias = diferenca / (1000 * 60 * 60 * 24) //transforma a diferença em dias
            idade = dias / 365 //calcula a idade
            return idade //retorna a idade
        }
    }
}