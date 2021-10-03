package ca.tetervak.donutdata.ui.donutlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.tetervak.donutdata.domain.Donut
import ca.tetervak.donutdata.repositories.DonutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DonutListViewModel @Inject constructor(
    private val repository: DonutRepository
) : ViewModel() {

    companion object{
        private const val TAG = "DonutListViewModel"
    }

    init{
        Log.d(TAG, "init: the DonutListViewModel object is created")
    }

    // Users of this ViewModel will observe changes to its donuts list to know when
    // to redisplay those changes
    val donuts: LiveData<List<Donut>> = repository.getAll()

    fun deleteAll() =
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
}
