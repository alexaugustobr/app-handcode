package com.handcode.app.apphandcode.service

import com.handcode.app.apphandcode.model.Evento
import com.handcode.app.apphandcode.utils.HttpHelper

object EventoService:BaseService() {
    fun listarEventos ():List<Evento>{
        val json = HttpHelper.get("https://opehandcode.herokuapp.com/rest/eventos")
        val eventos : List<Evento> = parserJson(json)
        return eventos
    }

}