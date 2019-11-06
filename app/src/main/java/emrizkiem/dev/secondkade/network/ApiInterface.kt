package emrizkiem.dev.secondkade.network

import emrizkiem.dev.secondkade.data.model.LeagueDetailResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/api/v1/json/1/lookupleague.php")
    fun getLeagueResponse(@Query("id") idLeague: String?) : Observable<LeagueDetailResponse>
}