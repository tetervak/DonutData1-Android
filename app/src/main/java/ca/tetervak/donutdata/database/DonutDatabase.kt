package ca.tetervak.donutdata.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DonutEntity::class], version = 1)
abstract class DonutDatabase : RoomDatabase() {

    abstract fun donutDao(): DonutDao

    companion object {
        @Volatile private var INSTANCE: DonutDatabase? = null

        fun getInstance(context: Context): DonutDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    DonutDatabase::class.java,
                    "donut_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
