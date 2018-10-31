package com.handcode.app.apphandcode.model

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface EntregaDAO {
    @Query ("SELECT * FROM entrega where id= :id")
    fun getById(id: Long): Entrega?

    @Query ("SELECT * FROM entrega")
    fun findAll():List<Entrega>

    @Insert
    fun insert (entrega: Entrega)

    @Delete
    fun delete(entrega: Entrega)
}