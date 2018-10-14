package com.handcode.app.apphandcode.model

import com.handcode.app.apphandcode.service.BaseService

object AlunoService : BaseService() {

    private val alunos : MutableMap<String, Aluno> = HashMap()

    init {
        alunos.put("aluno", Aluno("aluno","aluno","impacta"))
    }

    @Throws(AlunoNaoEncontradoException::class)
    fun buscar(usuario : String) : Aluno {
        return alunos.get(usuario) ?: throw AlunoNaoEncontradoException()
    }

}