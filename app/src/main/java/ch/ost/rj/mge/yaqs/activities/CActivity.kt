package ch.ost.rj.mge.yaqs.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import ch.ost.rj.mge.yaqs.R

class CActivity : AppCompatActivity() {

    private lateinit var backButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        backButton = findViewById(R.id.c_back)
    }

    fun createIntent(context : Context): Intent {
        val intent = Intent(context, CActivity::class.java)
        return intent
    }
}