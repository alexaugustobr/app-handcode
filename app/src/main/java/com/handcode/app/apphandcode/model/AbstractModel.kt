package com.handcode.app.apphandcode.model

import com.google.gson.GsonBuilder

import java.io.Serializable

abstract class AbstractModel : Serializable {
    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}