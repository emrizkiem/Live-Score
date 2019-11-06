package emrizkiem.dev.secondkade.data.model

import com.google.gson.annotations.SerializedName

data class LeagueDetail (
    @SerializedName("idLeague")
    val idLeague: String? = null,
    @SerializedName("strBadge")
    val badge: String? = null,
    @SerializedName("strLeague")
    val name: String? = null,
    @SerializedName("dateFirstEvent")
    val date: String? = null,
    @SerializedName("strCountry")
    val country: String? = null,
    @SerializedName("strWebsite")
    val website: String? = null,
    @SerializedName("strDescriptionEN")
    val description: String? = null
)