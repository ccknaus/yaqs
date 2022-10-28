package ch.ost.rj.mge.yaqs

import android.app.Application
import android.content.Context
import ch.ost.rj.mge.yaqs.model.LinkRepository

class YaqsApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        val context: Context = applicationContext

        LinkRepository.initialize(context)
    }
}