package emrizkiem.dev.secondkade.feature.league.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import emrizkiem.dev.secondkade.data.model.LeagueDetail

class ItemLeagueViewModel(model: LeagueDetail) : ViewModel() {

    var idLeague: ObservableField<String> = ObservableField()
    var badge: ObservableField<String> = ObservableField()
    var nameLeague: ObservableField<String> = ObservableField()
    var dateLeague: ObservableField<String> = ObservableField()

    init {
        idLeague.set(model.idLeague)
        badge.set(model.badge)
        nameLeague.set(model.name)
        dateLeague.set(model.date)
    }
}