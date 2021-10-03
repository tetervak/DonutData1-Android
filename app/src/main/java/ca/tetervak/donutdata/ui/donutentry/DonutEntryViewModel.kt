package ca.tetervak.donutdata.ui.donutentry

import android.util.Log
import androidx.lifecycle.*
import ca.tetervak.donutdata.domain.Donut
import ca.tetervak.donutdata.repositories.DonutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DonutEntryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: DonutRepository
) : ViewModel() {

    companion object{
        private const val TAG = "DonutEntryViewModel"
    }

    init{
        Log.d(TAG, "init: the DonutEntryViewModel is created")
    }

    private val donutId: String? = savedStateHandle["donutId"]

    val donut: LiveData<Donut> =
                liveData {
                    if (donutId == null) {
                        emit(Donut(null, "", "", 3.0F))
                    } else {
                        emit(repository.get(donutId))
                    }
                }
}
