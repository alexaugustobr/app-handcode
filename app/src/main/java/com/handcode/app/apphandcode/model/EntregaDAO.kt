package com.handcode.app.apphandcode.model

import android.arch.persistence.room.*

@Dao
interface EntregaDAO {
    @Query ("SELECT * FROM entrega where id= :id")
    fun getById(id: String): Entrega?

    @Query ("SELECT * FROM entrega")
    fun findAll():List<Entrega>

    @Insert
    fun insert (entrega: Entrega)

    @Delete
    fun delete(entrega: Entrega)

    @Query ("SELECT * FROM entrega where status= :status")
    fun findAllByStatus(status: String ): List<Entrega>

    @Update
    fun update(entrega: Entrega)
}