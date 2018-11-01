package com.handcode.app.apphandcode.model

import android.arch.persistence.room.PrimaryKey
import com.google.gson.GsonBuilder

import java.io.Serializable
import java.util.*


abstract class AbstractModel : Serializable {

    @PrimaryKey
    var id: UUID? = null

    fun toJson(): String {
        return GsonBuilder().setPrettyPrinting().create().toJson(this)
    }


}