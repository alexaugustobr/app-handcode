package com.handcode.app.apphandcode.model

class Aluno : Usuario {

    constructor(email: String, senha: String) : super(email, senha)
    constructor(nome: String, email: String, senha: String) : super(nome, email, senha)
}