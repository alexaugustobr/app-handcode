package com.handcode.app.apphandcode.model

import java.util.*

class Entrega : AbstractModel {

    var data: Date? = null
    var dataEntrega: Date? = null
    var dataLiberacao: Date? = null
    var status: Status = Status.PENDENTE
    var tarefa: Tarefa = Tarefa()

    constructor() : super()


    enum class Status(val nome : String) {

        PENDENTE("Pendente"),
        ENTREGUE("Entregue")

    }


}