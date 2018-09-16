package com.handcode.app.apphandcode

import android.content.Context

object DisciplinaService {

    fun getDisciplinas (context: Context): List<Disciplina> {
        val disciplinas = mutableListOf<Disciplina>()
        // criar 10 disciplinas
        for (i in 1..10) {
            val d = Disciplina()
            d.nome = "Disciplina $i"
            d.ementa = "Ementa Disciplina $i"
            d.professor = "Professor Disciplina $i"
            d.foto = "url de uma image"
            disciplinas.add(d)
        }
        return disciplinas
    }


}