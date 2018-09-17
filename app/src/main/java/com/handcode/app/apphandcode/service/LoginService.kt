package com.handcode.app.apphandcode.model

object LoginService {

    @Throws(AlunoNaoEncontradoException::class, SenhaIncorretaException::class)
    fun logar(usuario : String, senha : String) : Aluno {
        val aluno = AlunoService.buscar(usuario)
        if (!aluno.senha.equals(senha)) throw SenhaIncorretaException()
        return aluno
    }

}