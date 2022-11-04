package ch.ost.rj.mge.yaqs.model

import android.webkit.URLUtil


class ValidityChecker {

    fun isURL(input: String): Boolean {
        return URLUtil.isValidUrl(input)
    }

    fun isEmptyString(input: String): Boolean {
        return input == ""
    }

}