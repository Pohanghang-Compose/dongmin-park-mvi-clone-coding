package com.chattymin.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.chattymin.data.entity.NextEvolutionEntity

@Dao
interface NextEvolutionDao {
    @Insert
    suspend fun insert(nextEvolution: NextEvolutionEntity)

    @Insert
    suspend fun insertAll(nextEvolutions: List<NextEvolutionEntity>)

    @Update
    suspend fun update(nextEvolution: NextEvolutionEntity)

    @Delete
    suspend fun delete(nextEvolution: NextEvolutionEntity)

    @Query("SELECT * FROM next_evolutions where pokemonId = :pokemonId")
    suspend fun findNextEvolutions(pokemonId: Int): List<NextEvolutionEntity>
}
