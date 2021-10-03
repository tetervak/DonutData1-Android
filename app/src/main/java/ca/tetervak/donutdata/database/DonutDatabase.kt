package ca.tetervak.donutdata.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DonutEntity::class], version = 1, exportSchema = false)
abstract class DonutDatabase : RoomDatabase() {

    abstract fun donutDao(): DonutDao

    companion object {

        private const val TAG = "DonutDatabase"

        @Volatile private var INSTANCE: DonutDatabase? = null

        fun getInstance(context: Context): DonutDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                Log.d(TAG, "getInstance: the database object is returned")
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    DonutDatabase::class.java,
                    "donut_database"
                ).build()
                INSTANCE = instance
                Log.d(TAG, "getInstance: the database object is created")
                return instance
            }
        }
    }
}
