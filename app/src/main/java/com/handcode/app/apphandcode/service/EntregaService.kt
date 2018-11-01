package com.handcode.app.apphandcode.service

import android.content.Context
import com.handcode.app.apphandcode.model.Entrega
import com.handcode.app.apphandcode.utils.AndroidUtils
import com.handcode.app.apphandcode.utils.HttpHelper
import com.handcode.app.apphandcode.utils.Response


object EntregaService: BaseService() {

    val dao = DatabaseManager.getEntregaDAO()

    fun listarEntregas(context :Context, status: Entrega.Status): List<Entrega> {
        if (AndroidUtils.isInternetDisponivel(context)) {
            val json = HttpHelper.get(this.host() + "/rest/entregas?status=$status")
            val entregas: List<Entrega> = parserJson(json)
            savaOffline(entregas)
            return entregas
        } else {
            val dao = DatabaseManager.getEntregaDAO()
            val entregas = dao.findAllByStatus(status.toString())
            return entregas
        }
    }

    fun savaOffline (entrega: Entrega):Boolean{
        if (!existeEntrega(entrega.id)) {
            try {
                dao.insert(entrega)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return true
    }

    fun savaOffline (entregas: List<Entrega>):Boolean{
        for (entrega in entregas) {
            this.savaOffline(entrega)
        }
        return true
    }

    fun existeEntrega(id: String): Boolean {
        val entrega = dao.getById(id)
        return entrega != null
    }

    fun delete (entrega: Entrega):Response {
        val url = host()+"/entregas/${entrega.id}"
        val json = HttpHelper.delete(url)
        return parserJson<Response>(json)
    }


}