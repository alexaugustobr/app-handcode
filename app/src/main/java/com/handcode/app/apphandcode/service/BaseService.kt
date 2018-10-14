package com.handcode.app.apphandcode.service

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

abstract class BaseService {
    fun host() = "https://opehandcode.herokuapp.com"
    fun apiPrefix() = "/api/v1"
    fun loginURL() = host()+apiPrefix()+"/login"
    fun usuarioAutenticadoDetalhesURL() = host()+apiPrefix()+"/me"
    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}