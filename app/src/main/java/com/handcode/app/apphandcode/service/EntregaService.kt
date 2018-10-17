package com.handcode.app.apphandcode.service

import android.os.Bundle
import com.handcode.app.apphandcode.model.Entrega
import com.handcode.app.apphandcode.model.LoginService
import com.handcode.app.apphandcode.vo.TokenContainer
import fernandosousa.com.br.lmsapp.HttpHelper

object EntregaService:BaseService() {
    fun listarEntregas ():List<Entrega>{
        val json = HttpHelper.get("https://opehandcode.herokuapp.com/rest/entregas")
        val entregas : List<Entrega> = parserJson(json)
        return entregas
    }

}