package ch.ost.rj.mge.yaqs.activities

import android.Manifest
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.yaqs.R
import ch.ost.rj.mge.yaqs.intents.Intents
import ch.ost.rj.mge.yaqs.model.LinkRepository
import ch.ost.rj.mge.yaqs.permission.Camera

class CameraActivity : AppCompatActivity() {

    companion object {
        // model
        private const val CAMERA_PERMISSION_CODE = 1
        private const val URL = "https://www.ost.ch"
    }

    // view
    private lateinit var historyButton: Button
    private lateinit var copyButton : Button
    private lateinit var openLinkButton : Button

    // controller
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        copyButton = findViewById(R.id.camera_button_copy)
        copyButton.setOnClickListener{
            val time: Long = System.currentTimeMillis()
            LinkRepository.addLink(time, URL)
        }

        historyButton = findViewById(R.id.camera_button_history)
        historyButton.setOnClickListener{ startActivity((Intents.activityHistory(this))) }

        openLinkButton = findViewById(R.id.camera_button_openlink)
        openLinkButton.setOnClickListener{ startActivity(Intents.openURL(URL)) }

        requestCameraPermission()
    }

    private fun requestCameraPermission() =
        Camera.requestPermission(this, this, Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)

}