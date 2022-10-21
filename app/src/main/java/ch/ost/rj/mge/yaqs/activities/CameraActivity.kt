package ch.ost.rj.mge.yaqs.activities

import android.Manifest
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.yaqs.R
import ch.ost.rj.mge.yaqs.intents.intents.Companion.activityC
import ch.ost.rj.mge.yaqs.intents.intents.Companion.activityHistory
import ch.ost.rj.mge.yaqs.intents.intents.Companion.openURL

class CameraActivity : AppCompatActivity() {
    private val CAMERA_PERMISSION_CODE = 1
    // model
    private val URL = "https://www.ost.ch"

    // view
    private lateinit var historyButton: Button
    private lateinit var cButton : Button
    private lateinit var openLinkButton : Button

    // controller
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cButton = findViewById(R.id.camera_button_c)
        cButton.setOnClickListener{ startActivity(activityC(this)) }

        historyButton = findViewById(R.id.camera_button_history)
        historyButton.setOnClickListener{ startActivity((activityHistory(this))) }

        openLinkButton = findViewById(R.id.camera_button_openlink)
        openLinkButton.setOnClickListener{ startActivity(openURL(URL)) }
    }

    private fun requestCameraPermission() {
        requestPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)
    }

}