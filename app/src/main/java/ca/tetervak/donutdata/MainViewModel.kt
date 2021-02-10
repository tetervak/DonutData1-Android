package ca.tetervak.donutdata

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