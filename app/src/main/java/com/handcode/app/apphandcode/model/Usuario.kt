package com.handcode.app.apphandcode.model

open class Usuario : AbstractModel {

    var nome = ""
    var email = ""
    var senha = ""

    constructor( email: String, senha: String) {
        this.email = email
        this.senha = senha
    }

    constructor(nome: String, email: String, senha: String) {
        this.nome = nome
        this.email = email
        this.senha = senha
    }
}