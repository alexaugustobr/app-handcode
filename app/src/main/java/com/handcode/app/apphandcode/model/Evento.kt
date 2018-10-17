package com.handcode.app.apphandcode.model

import java.util.*


class Evento : AbstractModel {
    var data: Date? = null
    var descricao: String = ""
    var titulo: String = ""

    constructor() : super()
}