package ch.ost.rj.mge.yaqs

import ch.ost.rj.mge.yaqs.model.ValidityChecker
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class YAQSUnitTest {

    @Test
    fun NoURL_isURL() {
        assertEquals(false, ValidityChecker().isURL("gg"))
    }

    @Test
    fun URL_isURL() {
        assertEquals(true, ValidityChecker().isURL("https://www.ost.ch"))
    }

    @Test
    fun URLhttp_isURL() {
        assertEquals(true, ValidityChecker().isURL("http://www.ost.ch"))
    }

    @Test
    fun URLSlash_isURL() {
        assertEquals(true, ValidityChecker().isURL("https://www.ost.ch/"))
    }
}