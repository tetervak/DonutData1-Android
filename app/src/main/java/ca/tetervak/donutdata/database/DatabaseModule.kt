package ca.tetervak.donutdata.database

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDonutDao(application: Application): DonutDao {
        return DonutDatabase.getInstance(application).donutDao()
    }
}