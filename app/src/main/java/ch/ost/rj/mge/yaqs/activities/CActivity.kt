package ch.ost.rj.mge.yaqs.activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.yaqs.R
import ch.ost.rj.mge.yaqs.intents.Intents

class CActivity : AppCompatActivity() {

    private lateinit var backButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        backButton = findViewById(R.id.c_back)
        backButton.setOnClickListener { startActivity(Intents.activityCamera(this)) }
    }


}