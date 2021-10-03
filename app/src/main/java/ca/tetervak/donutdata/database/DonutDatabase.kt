package ca.tetervak.donutdata.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DonutEntity::class], version = 1, exportSchema = false)
abstract class DonutDatabase : RoomDatabase() {

    abstract fun donutDao(): DonutDao
}
