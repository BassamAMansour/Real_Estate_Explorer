package org.sweng.realestateexplorer.ui.estatelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.sweng.realestateexplorer.data.estates.Estate
import org.sweng.realestateexplorer.data.estates.EstateRepository

class EstateListViewModel(private val repo: EstateRepository) : ViewModel() {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _estates = MutableLiveData<List<Estate>>(emptyList())
    val estates: LiveData<List<Estate>>
        get() = _estates

    init {
        uiScope.launch {
            _estates.value = repo.getEstates()
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}

class EstateListViewModelFactory(private val repo: EstateRepository) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EstateListViewModel::class.java)) {
            return EstateListViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
