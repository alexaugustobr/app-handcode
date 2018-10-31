package com.handcode.app.apphandcode.service

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.handcode.app.apphandcode.model.Entrega
import com.handcode.app.apphandcode.model.EntregaDAO

@Database(entities = arrayOf(Entrega::class), version = 1)
abstract class LMSDatabase: RoomDatabase() {
    abstract fun entregaDAO(): EntregaDAO
}