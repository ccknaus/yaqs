package ch.ost.rj.mge.yaqs.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.yaqs.R
import ch.ost.rj.mge.yaqs.model.LinkRepository.getLinks

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
    }

    override fun onResume() {
        super.onResume()
        getLinks()
    }

}