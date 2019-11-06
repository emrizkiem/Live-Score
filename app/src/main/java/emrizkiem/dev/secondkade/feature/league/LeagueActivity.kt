package emrizkiem.dev.secondkade.feature.league

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import emrizkiem.dev.secondkade.R
import emrizkiem.dev.secondkade.databinding.ActivityLeagueBinding
import emrizkiem.dev.secondkade.feature.league.adapter.LeagueAdapter
import emrizkiem.dev.secondkade.feature.league.viewmodel.LeagueViewModel
import org.jetbrains.anko.toast

class LeagueActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLeagueBinding
    private lateinit var viewModel: LeagueViewModel
    private lateinit var adapter: LeagueAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_league)
        viewModel = ViewModelProviders.of(this).get(LeagueViewModel::class.java)
        binding.league = viewModel

        setUpRecyclerView()
        observeLiveData()
        viewModel.getLeague()
    }

    private fun setUpRecyclerView() {
        val layoutManager = GridLayoutManager(this, 2)
        binding.rvLeague.layoutManager = layoutManager
        adapter = LeagueAdapter(this)
        binding.rvLeague.adapter = adapter
    }

    private fun observeLiveData() {
        viewModel.league.observe(this, Observer {
            adapter.setData(it.league)
            adapter.notifyDataSetChanged()
        })
        viewModel.error.observe(this, Observer {
            toast(it.message.toString())
        })
    }
}
