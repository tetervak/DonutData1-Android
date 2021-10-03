package ca.tetervak.donutdata.database

import android.app.Application
import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val TAG = "DataBaseModule"

    @Provides
    fun provideDonutDao(application: Application): DonutDao {
        Log.d(TAG, "provideDonutDao: the DonutDao object is returned")
        return DonutDatabase.getInstance(application).donutDao()
    }
}