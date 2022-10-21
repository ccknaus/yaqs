package ch.ost.rj.mge.yaqs.permission

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.app.ActivityCompat.shouldShowRequestPermissionRationale
import androidx.core.content.ContextCompat

class camera {

    companion object {

        private fun checkPermission(context: Context, permission: String): Boolean {
            return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
        }

        @SuppressLint("NewApi")
        private fun requestPermission(activity: Activity, context: Context, permission: String, requestCode: Int) {
            if (checkPermission(context, permission))
                return
            if (shouldShowRequestPermissionRationale(activity, permission)) {
                Toast.makeText(context, "Erklärung anzeigen für: $permission", Toast.LENGTH_SHORT).show()
            }
            requestPermissions(activity, arrayOf(permission), requestCode)
        }

    }
}