package com.handcode.app.apphandcode.service

import com.handcode.app.apphandcode.model.Entrega
import fernandosousa.com.br.lmsapp.HttpHelper

object EntregaService:BaseService() {
    fun listarEntregas(status: Entrega.Status):List<Entrega>{
        val json = HttpHelper.get(this.host()+"/rest/entregas?status=$status")
        val entregas : List<Entrega> = parserJson(json)
        return entregas
    }

}