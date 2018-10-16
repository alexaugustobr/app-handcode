package com.handcode.app.apphandcode.service

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

abstract class BaseService {
    fun host() = "https://opehandcode.herokuapp.com"
    fun apiPrefix() = "/api/v1"
    fun restPrefix() = "/rest"
    fun loginURL() = host()+apiPrefix()+"/login"
    fun usuarioAutenticadoDetalhesURL() = host()+apiPrefix()+"/me"
    fun usuarioNaoAutenticadoURL() = host()+restPrefix()
    fun turmasURL() = host()+restPrefix()+"/turmas"
    fun cursosURL() = host()+restPrefix()+"/cursos"

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}