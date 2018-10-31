package com.handcode.app.apphandcode.service

import android.content.Context
import com.handcode.app.apphandcode.model.Entrega
import com.handcode.app.apphandcode.utils.AndroidUtils
import fernandosousa.com.br.lmsapp.HttpHelper

object EntregaService:BaseService() {

    fun listarEntregas(context:Context, status: Entrega.Status): List<Entrega> {
        if (AndroidUtils.isInternetDisponivel(context)) {
            val json = HttpHelper.get(this.host() + "/rest/entregas?status=$status")
            val entregas: List<Entrega> = parserJson(json)
            return entregas
        } else {
            val dao = DatabaseManager.getEntregaDAO()
            val entregas = dao.findAll()
            return entregas
        }
    }
}