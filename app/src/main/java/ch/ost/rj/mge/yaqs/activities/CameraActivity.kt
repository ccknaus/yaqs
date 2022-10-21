package ch.ost.rj.mge.yaqs.activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.yaqs.R
import ch.ost.rj.mge.yaqs.intents.Intents

class CameraActivity : AppCompatActivity() {

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
        cButton.setOnClickListener{ startActivity(Intents.activityC(this)) }

        historyButton = findViewById(R.id.camera_button_history)
        historyButton.setOnClickListener{ startActivity((Intents.activityHistory(this))) }

        openLinkButton = findViewById(R.id.camera_button_openlink)
        openLinkButton.setOnClickListener{ startActivity(Intents.openURL(URL)) }

        requestCameraPermission()
    }

    private fun requestCameraPermission() =
        Camera.requestPermission(this, this, Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)

}