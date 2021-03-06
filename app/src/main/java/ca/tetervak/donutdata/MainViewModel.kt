package ca.tetervak.donutdata

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.tetervak.donutdata.domain.Donut
import ca.tetervak.donutdata.repositories.DonutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: DonutRepository
) : ViewModel() {

    companion object{
        private const val TAG = "MainViewModel"
    }

    init {
        Log.d(TAG, "init: the MainViewModel is created")
    }

    fun delete(donut: Donut) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(donut)
        }

    fun save(donut: Donut) =
        viewModelScope.launch(Dispatchers.IO) {
            if (donut.id == null) {
                repository.insert(donut)
            } else {
                repository.update(donut)
            }
        }
}