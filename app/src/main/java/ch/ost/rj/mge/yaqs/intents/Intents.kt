package ch.ost.rj.mge.yaqs.intents

import android.content.Context
import android.content.Intent
import android.net.Uri
import ch.ost.rj.mge.yaqs.activities.CopyActivity
import ch.ost.rj.mge.yaqs.activities.CameraActivity
import ch.ost.rj.mge.yaqs.activities.HistoryActivity

class Intents {

    companion object {
        internal fun openURL(URL : String) : Intent {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(URL)
            return intent
        }

        internal fun activityCopy(context : Context) : Intent {
            return Intent(context, CopyActivity::class.java)
        }

        internal fun activityCamera(context : Context) : Intent {
            return Intent(context, CameraActivity::class.java)
        }

        internal fun activityHistory(context : Context) : Intent {
            return Intent(context, HistoryActivity::class.java)
        }

    }
}