package ca.tetervak.donutdata.ui.donutentry

import androidx.lifecycle.*
import ca.tetervak.donutdata.domain.Donut
import ca.tetervak.donutdata.repositories.DonutRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DonutEntryViewModel @Inject constructor(
        private val repository: DonutRepository
) : ViewModel() {

    private val donutId = MutableLiveData<String?>()

    fun loadData(id: String?) {
        donutId.value = id
    }

    val donut: LiveData<Donut> =
            donutId.switchMap { id ->
                liveData {
                    if (id == null) {
                        emit(Donut(null, "", "", 3.0F))
                    } else {
                        emit(repository.get(id))
                    }
                }
            }
}
