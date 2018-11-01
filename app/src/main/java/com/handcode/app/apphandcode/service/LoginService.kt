package com.handcode.app.apphandcode.model

import com.handcode.app.apphandcode.service.BaseService
import com.handcode.app.apphandcode.utils.HttpHelper
import com.handcode.app.apphandcode.vo.TokenContainer

object LoginService : BaseService() {

    @Throws(AlunoNaoEncontradoException::class, SenhaIncorretaException::class)
    fun logar(email : String, senha : String) : TokenContainer {

        val http = HttpHelper.getHttp("https://opehandcode.herokuapp.com")

        val json = HttpHelper.post(loginURL(), Aluno(email,senha).toJson())
        val tokenContainer : TokenContainer = parserJson(json)
        return tokenContainer
    }

    fun informacoesUsuarioAutenticado(tokenContainer : TokenContainer) : Aluno {
        val json = HttpHelper.getAutenticado(usuarioAutenticadoDetalhesURL(),tokenContainer)
        val aluno : Aluno = parserJson(json)
        return aluno
    }
}