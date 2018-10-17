package com.handcode.app.apphandcode.service

import com.handcode.app.apphandcode.model.Evento
import com.handcode.app.apphandcode.model.LoginService
import fernandosousa.com.br.lmsapp.HttpHelper

object EventoService:BaseService() {
    fun listarEventos ():List<Evento>{
        val json = HttpHelper.get("https://opehandcode.herokuapp.com/rest/eventos")
        val eventos : List<Evento> = parserJson(json)
        return eventos
    }

}