package com.handcode.app.apphandcode.vo

class TokenContainer(val token: String ) {

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