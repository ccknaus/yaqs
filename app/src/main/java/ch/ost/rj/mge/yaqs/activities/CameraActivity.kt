package ch.ost.rj.mge.yaqs.activities

import android.Manifest
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ch.ost.rj.mge.yaqs.R
import ch.ost.rj.mge.yaqs.adapter.HistoryAdapter
import ch.ost.rj.mge.yaqs.intents.Intents
import ch.ost.rj.mge.yaqs.model.LinkRepository
import ch.ost.rj.mge.yaqs.permission.Camera
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions


class CameraActivity : AppCompatActivity() {

    companion object {
        private const val CAMERA_PERMISSION_CODE = 1
        private lateinit var barcodeLauncher: ActivityResultLauncher<ScanOptions>
        private var scannedResult = ""
    }

    private lateinit var historyButton: Button
    private lateinit var copyButton : Button
    private lateinit var openLinkButton : Button
    private lateinit var adapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = HistoryAdapter()
        setupRecyclerView(this, adapter)

        requestCameraPermission()

        initBarcodeLauncher()
        barcodeLauncher.launch(ScanOptions().setOrientationLocked(false))

        setupCopyButton()

        historyButton = findViewById(R.id.camera_button_camera)
        historyButton.setOnClickListener{ barcodeLauncher.launch(ScanOptions()) }

        openLinkButton = findViewById(R.id.camera_button_openlink)
        openLinkButton.setOnClickListener{ startActivity(Intents.openURL(scannedResult)) }
    }

    override fun onResume() {
        super.onResume()
        refreshHistoryView()
    }

    private fun refreshHistoryView() {
        adapter.updateLinkList(LinkRepository.getLinks())
    }


    private fun setupCopyButton() {
        val clipboard = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager

        copyButton = findViewById(R.id.camera_button_copy)
        copyButton.setOnClickListener{
            val clip = ClipData.newPlainText("Link", scannedResult)
            clipboard.setPrimaryClip(clip)
            Toast.makeText(applicationContext, "Copied to Clipboard", Toast.LENGTH_SHORT).show()
            val time: Long = System.currentTimeMillis()
            LinkRepository.addLink(time, "something new")
            refreshHistoryView()
        }
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
                val time: Long = System.currentTimeMillis()
                LinkRepository.addLink(time, scannedResult)
            }
        }
    }

    private fun setupRecyclerView(context: Context, adapter: HistoryAdapter) {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        val recyclerView: RecyclerView = findViewById(R.id.history_links)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerView.itemAnimator = DefaultItemAnimator()
    }
}