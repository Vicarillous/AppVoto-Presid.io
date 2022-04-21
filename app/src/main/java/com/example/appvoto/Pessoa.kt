package com.example.appvoto

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class Pessoa {

    companion object {
        private var dataNasc: String = "" //data de nascimento
        private var idade: Long = 0 //idade

        fun getIdade(): Long { //retorna a idade
            return idade
        }

        fun setDataNasc(dataNasc: String) { //seta a data de nascimento
            this.dataNasc = dataNasc
        }

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