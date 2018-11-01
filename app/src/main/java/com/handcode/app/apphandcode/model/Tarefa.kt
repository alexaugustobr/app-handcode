package com.handcode.app.apphandcode.model

import java.io.Serializable
import java.util.*

class Tarefa : Serializable {
    var dataCriacao : Date = Date()
    var dataHora : Date = Date()
    var descricao : String = ""
    var titulo : String = ""

}