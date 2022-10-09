package ch.ost.rj.mge.yaqs.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.yaqs.R

class CameraActivity : AppCompatActivity() {

    private val LINK_URL = "https://www.ost.ch"

    private lateinit var historyButton: Button
    private lateinit var cButton : Button
    private lateinit var openLinkButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cButton = findViewById(R.id.camera_button_c)
        cButton.setOnClickListener{ showCActivity() }

        historyButton = findViewById(R.id.camera_button_history)
        historyButton.setOnClickListener{ showHistoryActivity() }

        openLinkButton = findViewById(R.id.camera_button_openlink)
        openLinkButton.setOnClickListener{ openURL() }

    }

    private fun openURL(intent : Intent = Intent(Intent.ACTION_VIEW)) {
        intent.data = Uri.parse(LINK_URL)
        startActivity(intent)
    }

    private fun showCActivity() {
        val intent : Intent = CActivity().createIntent(this)
        startActivity(intent)
    }

    private fun showHistoryActivity() {
        val intent : Intent = HistoryActivity().createIntent(this)
        startActivity(intent)
    }
}