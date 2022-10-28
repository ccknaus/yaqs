package ch.ost.rj.mge.yaqs.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import ch.ost.rj.mge.yaqs.R
import ch.ost.rj.mge.yaqs.adapter.HistoryAdapter
import ch.ost.rj.mge.yaqs.model.LinkRepository

class HistoryActivity : AppCompatActivity() {
    private lateinit var adapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val layoutManager: LayoutManager = LinearLayoutManager(this)
        adapter = HistoryAdapter()
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        val recyclerView: RecyclerView = findViewById(R.id.history_links)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(dividerItemDecoration)
    }

    override fun onResume() {
        super.onResume()
        adapter.updateLinkList(LinkRepository.getLinks())
    }

}