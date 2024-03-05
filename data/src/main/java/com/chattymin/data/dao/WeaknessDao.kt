package com.chattymin.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.chattymin.data.entity.WeaknessEntity

@Dao
interface WeaknessDao {
    @Insert
    suspend fun insert(weakness: WeaknessEntity)

    @Insert
    suspend fun insertAll(weaknesses: List<WeaknessEntity>)

    @Update
    suspend fun update(weakness: WeaknessEntity)

    @Delete
    suspend fun delete(weakness: WeaknessEntity)

    @Query("SELECT * FROM weaknesses where pokemonId = :pokemonId")
    suspend fun findTypes(pokemonId: Int): List<WeaknessEntity>
}
