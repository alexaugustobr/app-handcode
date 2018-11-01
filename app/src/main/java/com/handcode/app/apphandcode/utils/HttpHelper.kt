package com.handcode.app.apphandcode.utils

import android.util.Log
import com.handcode.app.apphandcode.exception.*
import com.handcode.app.apphandcode.vo.TokenContainer
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import java.util.concurrent.TimeUnit

object HttpHelper {

    private val TAG = "HTTP_LMSApp"
    private val LOG_ON = true
    val JSON = MediaType.parse("application/json; charset=utf-8")

    var client = OkHttpClient.Builder().connectTimeout(15, TimeUnit.MINUTES).build()

    // GET
    @Throws(ErroInternoNoServidorException::class,
            RequisicaoIncorretaException::class,
            RequisicaoNaoEncontradaException::class,
            FalhaNaAutenticacaoDaRequisicaoException::class)
    fun get(url:String): String {
        Log.d(TAG, "HttpHelper.get: $url")
        val request = Request.Builder().url(url).get().build()
        return executeAndParseJson(request)
    }

    // GET
    @Throws(ErroInternoNoServidorException::class,
            RequisicaoIncorretaException::class,
            RequisicaoNaoEncontradaException::class,
            FalhaNaAutenticacaoDaRequisicaoException::class)
    fun getAutenticado(url:String, tokenContainer: TokenContainer): String {
        Log.d(TAG, "HttpHelper.get: $url")
        val request = Request.Builder().header(tokenContainer.getTokenHeaderName(),tokenContainer.getTokenWithPrefix()).url(url).get().build()
        return executeAndParseJson(request)
    }

    // POST JSON
    @Throws(ErroInternoNoServidorException::class,
            RequisicaoIncorretaException::class,
            RequisicaoNaoEncontradaException::class,
            FalhaNaAutenticacaoDaRequisicaoException::class)
    fun postAutenticado(url: String, json: String, tokenContainer: TokenContainer): String {
        Log.d(TAG, "HttpHelper.post: $url > $json")
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder().header(tokenContainer.getTokenHeaderName(),tokenContainer.getTokenWithPrefix()).url(url).post(body).build()
        return executeAndParseJson(request)
    }

    // POST JSON
    @Throws(ErroInternoNoServidorException::class,
            RequisicaoIncorretaException::class,
            RequisicaoNaoEncontradaException::class,
            FalhaNaAutenticacaoDaRequisicaoException::class)
    fun post(url: String, json: String): String {
        Log.d(TAG, "HttpHelper.post: $url > $json")
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder().url(url).post(body).build()
        return executeAndParseJson(request)
    }

    // DELETE
    @Throws(ErroInternoNoServidorException::class,
            RequisicaoIncorretaException::class,
            RequisicaoNaoEncontradaException::class,
            FalhaNaAutenticacaoDaRequisicaoException::class)
    fun delete(url: String): String {
        Log.d(TAG, "HttpHelper.delete: $url")
        val request = Request.Builder().url(url).delete().build()
        return executeAndParseJson(request)
    }


    // Lê resposta em formato JSON
    @Throws(ErroInternoNoServidorException::class,
            RequisicaoIncorretaException::class,
            RequisicaoNaoEncontradaException::class,
            FalhaNaAutenticacaoDaRequisicaoException::class)
    private fun executeAndParseJson(request: Request?): String {


        val response = client.newCall(request).execute()

        if (response.code() == 500) {
            throw ErroInternoNoServidorException()
        }

        if (response.code() == 400) {
            throw RequisicaoIncorretaException()
        }

        if (response.code() == 401) {
            throw FalhaNaAutenticacaoDaRequisicaoException()
        }

        if (response.code() != 200) {
            throw ErroInternoNoServidorException()
        }

        val body = response.body()


        try {
            val json = body!!.string()
            Log.d(TAG, "  << : $json")
            return json
        } catch (e : Exception) {
            e.printStackTrace()
            Log.getStackTraceString(e)
            throw  ErroAoProcessarOCorpoDaRequisicaoException(e)
        }

    }

    fun getHttp(url: String) = client.newCall(Request.Builder().url(url).get().build()).execute()
}