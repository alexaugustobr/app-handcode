package com.handcode.app.apphandcode.model

object AlunoService {

    private val alunos : MutableMap<String, Aluno> = HashMap()

    init {
        alunos.put("aluno", Aluno("aluno","aluno","impacta"))
    }

    @Throws(AlunoNaoEncontradoException::class)
    fun buscar(usuario : String) : Aluno {
        return alunos.get(usuario) ?: throw AlunoNaoEncontradoException()
    }

}