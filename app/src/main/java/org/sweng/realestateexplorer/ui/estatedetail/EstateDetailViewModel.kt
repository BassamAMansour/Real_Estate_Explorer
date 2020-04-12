package org.sweng.realestateexplorer.ui.estatedetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.sweng.realestateexplorer.data.estates.Estate

class EstateDetailViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val estate: MutableLiveData<Estate> = MutableLiveData()

    init {
        estate.observeForever { updateEstate(it.id) }
    }

    private fun updateEstate(estateId: String) {
        TODO("Not yet implemented")
    }
}
