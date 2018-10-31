package com.handcode.app.apphandcode.model


import com.google.gson.GsonBuilder

import java.io.Serializable
import java.util.*


abstract class AbstractModel : Serializable {
    var id: UUID? = null

    fun toJson(): String {
        return GsonBuilder().setPrettyPrinting().create().toJson(this)
    }


}