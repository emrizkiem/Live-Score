package emrizkiem.dev.secondkade.data.model

import com.google.gson.annotations.SerializedName

data class LeagueDetailResponse (
    @SerializedName("leagues")
    val league: MutableList<LeagueDetail>
)
