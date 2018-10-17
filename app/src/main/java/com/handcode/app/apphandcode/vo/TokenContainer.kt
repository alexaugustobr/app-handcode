package com.handcode.app.apphandcode.vo

import java.io.Serializable

class TokenContainer(val token: String ) : Serializable {

    fun getTokenPrefix() : String {
        return "Bearer"
    }

    fun getTokenHeaderName() : String {
        return "Authorization"
    }

    fun getTokenWithPrefix() : String {
        return "Bearer $token"
    }


}