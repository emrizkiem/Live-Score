package emrizkiem.dev.secondkade.feature.league.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import emrizkiem.dev.secondkade.R
import emrizkiem.dev.secondkade.databinding.ItemLeagueRowBinding
import emrizkiem.dev.secondkade.data.model.LeagueDetail
import emrizkiem.dev.secondkade.feature.league.viewmodel.ItemLeagueViewModel

class LeagueAdapter(val context: Context) : RecyclerView.Adapter<LeagueAdapter.ViewHolder>() {

    private var leagueList: MutableList<LeagueDetail> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding : ItemLeagueRowBinding =
            DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_league_row, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = leagueList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(leagueList[holder.adapterPosition])
    }

    fun setData(league: MutableList<LeagueDetail>) {
        this.leagueList = league
    }

    class ViewHolder(private val binding: ItemLeagueRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model : LeagueDetail) {
            val viewModel = ItemLeagueViewModel(model)
            binding.itemLeague = viewModel
        }
    }
}