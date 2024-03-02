package com.chattymin.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chattymin.data.dao.ImageDao
import com.chattymin.data.dao.MultiplierDao
import com.chattymin.data.dao.NextEvolutionDao
import com.chattymin.data.dao.PokemonDao
import com.chattymin.data.dao.PrevEvolutionDao
import com.chattymin.data.dao.TypeDao
import com.chattymin.data.dao.WeaknessDao
import com.chattymin.data.entity.ImageEntity
import com.chattymin.data.entity.MultiplierEntity
import com.chattymin.data.entity.NextEvolutionEntity
import com.chattymin.data.entity.PokemonEntity
import com.chattymin.data.entity.PrevEvolutionEntity
import com.chattymin.data.entity.TypeEntity
import com.chattymin.data.entity.WeaknessEntity

@Database(
    entities = [
        MultiplierEntity::class,
        NextEvolutionEntity::class,
        PrevEvolutionEntity::class,
        PokemonEntity::class,
        TypeEntity::class,
        WeaknessEntity::class,
        ImageEntity::class,
    ],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMultiplierDao(): MultiplierDao
    abstract fun getNextEvolutionDao(): NextEvolutionDao
    abstract fun getPrevEvolutionDao(): PrevEvolutionDao
    abstract fun getPokemonDao(): PokemonDao
    abstract fun getTypeDao(): TypeDao
    abstract fun getWeaknessDao(): WeaknessDao
    abstract fun getImageDao(): ImageDao
}
