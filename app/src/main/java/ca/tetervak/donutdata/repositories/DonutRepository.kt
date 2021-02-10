package ca.tetervak.donutdata.repositories

import androidx.lifecycle.LiveData
import ca.tetervak.donutdata.domain.Donut

interface DonutRepository {
    fun getAll(): LiveData<List<Donut>>
    suspend fun get(id: String): Donut
    suspend fun insert(donut: Donut): Long
    suspend fun delete(donut: Donut)
    suspend fun update(donut: Donut)
}