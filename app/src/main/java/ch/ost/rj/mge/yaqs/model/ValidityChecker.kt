package ch.ost.rj.mge.yaqs.model

import java.util.regex.Matcher
import java.util.regex.Pattern


class ValidityChecker {
    var regExPattern: Pattern = Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")

    fun isURL(input: String): Boolean {
        val matcher: Matcher = regExPattern.matcher(input)
        return matcher.matches()
    }

    fun isEmptyString(input: String): Boolean {
        return input == ""
    }

}