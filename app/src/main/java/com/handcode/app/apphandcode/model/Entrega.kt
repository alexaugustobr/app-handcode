package com.handcode.app.apphandcode.model

import java.util.*

class Entrega : AbstractModel {

    var data: Date? = null
    var descricao: String = ""
    var titulo: String = ""
    var dataEntrega: Date? = null
    var dataLiberacao: Date? = null
    var situacaoEntega: Status = Status.PENDENTE

    constructor() : super()


    enum class Status(val nome : String) {

        PENDENTE("Pendente"),
        ENTREGUE("Entregue")

    }

    override fun toString(): String {
        return "Entrega(data=$data, descricao='$descricao', titulo='$titulo', dataEntrega=$dataEntrega, dataLiberacao=$dataLiberacao, situacaoEntega=$situacaoEntega)"
    }


}