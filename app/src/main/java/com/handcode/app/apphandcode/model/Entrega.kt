package com.handcode.app.apphandcode.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

import java.util.*

@Entity(tableName = "entrega")
class Entrega : AbstractModel {

    @PrimaryKey
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