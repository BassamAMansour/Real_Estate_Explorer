package org.sweng.realestateexplorer.ui.estatedetail

import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import org.sweng.realestateexplorer.data.estates.Estate
import org.sweng.realestateexplorer.data.users.User
import org.sweng.realestateexplorer.data.users.UserRepository

class EstateDetailViewModel : ViewModel() {

    // TODO: Implement the ViewModel
    val estate: MutableLiveData<Estate> = MutableLiveData()
    val user: LiveData<User> = estate.switchMap {
        liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            emit(UserRepository().getUser(it.ownerId))
        }
    }
}
