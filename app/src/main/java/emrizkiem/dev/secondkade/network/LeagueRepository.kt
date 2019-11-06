package emrizkiem.dev.secondkade.network

import emrizkiem.dev.secondkade.data.model.LeagueDetailResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LeagueRepository {
    private val apiService = ApiFactory.create()
    private val compositeDisposable = CompositeDisposable()

    fun requestLeague(onResult: (LeagueDetailResponse) -> Unit, onError: (Throwable) -> Unit) {
        apiService.getLeagueResponse(idLeague = String())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ApiObserver<LeagueDetailResponse>(compositeDisposable) {
                override fun onApiSuccess(data: LeagueDetailResponse) {
                    onResult(data)
                }

                override fun onApiError(err: Throwable) {
                    onError(err)
                }
            })
    }

    fun onDestroy() {
        compositeDisposable.clear()
    }
}