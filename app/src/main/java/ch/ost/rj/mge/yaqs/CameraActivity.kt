package ch.ost.rj.mge.yaqs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class CameraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonC = findViewById<Button>(R.id.camera_button_c)
        buttonC.setOnClickListener {
            val intent = Intent(this@CameraActivity, CActivity::class.java)
            startActivity(intent)
        }

    }
}