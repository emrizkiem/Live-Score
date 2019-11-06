package emrizkiem.dev.secondkade.feature.league.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import emrizkiem.dev.secondkade.data.model.LeagueDetailResponse
import emrizkiem.dev.secondkade.network.LeagueRepository

class LeagueViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = LeagueRepository()
    var league: MutableLiveData<LeagueDetailResponse> = MutableLiveData()
    var error: MutableLiveData<Throwable> = MutableLiveData()

    fun getLeague() {
        repository.requestLeague({
            league.postValue(it)
        }, {
            error.postValue(it)
        })
    }

    override fun onCleared() {
        super.onCleared()
        repository.onDestroy()
    }
}