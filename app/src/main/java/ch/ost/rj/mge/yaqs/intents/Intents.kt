package ch.ost.rj.mge.yaqs.intents

import android.content.Context
import android.content.Intent
import android.net.Uri
import ch.ost.rj.mge.yaqs.activities.CameraActivity

class Intents {

    companion object {
        internal fun openURL(URL : String) : Intent {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(URL)
            return intent
        }

        internal fun activityCamera(context : Context) : Intent {
            return Intent(context, CameraActivity::class.java)
        }

    }
}