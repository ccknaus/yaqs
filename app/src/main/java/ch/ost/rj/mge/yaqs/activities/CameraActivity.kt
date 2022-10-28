package ch.ost.rj.mge.yaqs.activities

// import ch.ost.rj.mge.yaqs.model.LinkRepository.addLink

import android.Manifest
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.yaqs.R
import ch.ost.rj.mge.yaqs.intents.Intents
import ch.ost.rj.mge.yaqs.permission.Camera
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions


class CameraActivity : AppCompatActivity() {

    companion object {
        // model
        private const val CAMERA_PERMISSION_CODE = 1
        private lateinit var barcodeLauncher: ActivityResultLauncher<ScanOptions>
        private var scannedResult = ""
    }

    // view
    private lateinit var historyButton: Button
    private lateinit var copyButton : Button
    private lateinit var openLinkButton : Button

    // controller
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        requestCameraPermission()
        initBarcodeLauncher()
        barcodeLauncher.launch(ScanOptions())

        copyButton = findViewById(R.id.camera_button_copy)
//        copyButton.setOnClickListener{ startActivity(Intents.activityCopy(this)) }
        copyButton.setOnClickListener{
//            addLink(scannedResult)
        }

        historyButton = findViewById(R.id.camera_button_history)
        historyButton.setOnClickListener{ startActivity((Intents.activityHistory(this))) }

        openLinkButton = findViewById(R.id.camera_button_openlink)
        openLinkButton.setOnClickListener{ startActivity(Intents.openURL(scannedResult)) }
    }

    private fun requestCameraPermission() =
        Camera.requestPermission(this, this, Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)

    private fun initBarcodeLauncher() {
        barcodeLauncher = registerForActivityResult(
            ScanContract()
        ) { result: ScanIntentResult ->
            if (result.contents == null) {
                Toast.makeText(this@CameraActivity, "Cancelled", Toast.LENGTH_LONG).show()
            } else {
                scannedResult = result.contents
                Toast.makeText(this@CameraActivity, "Scanned: " + result.contents, Toast.LENGTH_LONG).show()
            }
        }
    }
}