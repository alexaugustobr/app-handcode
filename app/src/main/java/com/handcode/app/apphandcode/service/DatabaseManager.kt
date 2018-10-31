package com.handcode.app.apphandcode.service

import android.arch.persistence.room.Room
import com.handcode.app.apphandcode.LMSApplication
import com.handcode.app.apphandcode.model.EntregaDAO

object DatabaseManager {
    private var dbInstance: LMSDatabase

    init {
        val appContext = LMSApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
                appContext,
                LMSDatabase::class.java,
                "ope.sqlite"
        ).build()
    }

    fun getEntregaDAO(): EntregaDAO {
        return dbInstance.entregaDAO()
    }
}