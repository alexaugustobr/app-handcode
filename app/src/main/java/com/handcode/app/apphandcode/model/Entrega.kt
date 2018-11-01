package com.handcode.app.apphandcode.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "entrega")
class Entrega : Serializable {

    @PrimaryKey
    var id: String = ""
    var dataEntrega: String? = ""
    var status: String? = Status.PENDENTE.toString()
    var titulo: String = ""
    var descricao : String = ""

    constructor() : super()

    enum class Status(val nome : String) {

        PENDENTE("Pendente"),
        REALIZADA("Realizada")

    }

}