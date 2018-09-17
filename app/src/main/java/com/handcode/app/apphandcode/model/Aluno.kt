package com.handcode.app.apphandcode.model

import java.io.Serializable

class Aluno : Serializable {

    var nome = ""
    var usuario = ""
    var senha = ""

    constructor(nome: String, usuario: String, senha: String) {
        this.nome = nome
        this.usuario = usuario
        this.senha = senha
    }
}