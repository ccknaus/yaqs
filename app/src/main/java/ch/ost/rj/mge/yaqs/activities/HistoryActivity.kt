package ch.ost.rj.mge.yaqs.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.yaqs.R

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
    }

    fun createIntent(context : Context): Intent {
        val intent = Intent(context, HistoryActivity::class.java)
        return intent
    }
}