package ch.ost.rj.mge.yaqs.intents

import android.content.Context
import android.content.Intent
import android.net.Uri
import ch.ost.rj.mge.yaqs.activities.CActivity
import ch.ost.rj.mge.yaqs.activities.CameraActivity
import ch.ost.rj.mge.yaqs.activities.HistoryActivity

class intents {

    companion object {
        internal fun openURL(URL : String) : Intent {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(URL)
            return intent
        }

        internal fun activityC(context : Context) : Intent {
            return Intent(context, CActivity::class.java)
        }

        internal fun activityCamera(context : Context) : Intent {
            return Intent(context, CameraActivity::class.java)
        }

        internal fun activityHistory(context : Context) : Intent {
            return Intent(context, HistoryActivity::class.java)
        }

    }
}