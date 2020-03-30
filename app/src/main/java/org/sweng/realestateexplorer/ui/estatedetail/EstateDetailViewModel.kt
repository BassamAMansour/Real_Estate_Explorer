package org.sweng.realestateexplorer.ui.estatedetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EstateDetailViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    val estateId: MutableLiveData<String> = MutableLiveData()

    init {
        estateId.observeForever { updateEstate(it) }
    }

    private fun updateEstate(estateId: String) {
        TODO("Not yet implemented")
    }
}
