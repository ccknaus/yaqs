package ch.ost.rj.mge.yaqs.model

import android.content.Context
import androidx.room.Room
import ch.ost.rj.mge.yaqs.model.storage.LinkDatabase

object LinkRepository {
    private lateinit var database: LinkDatabase

    fun initialize(context: Context) {
        database = Room
            .databaseBuilder(context, LinkDatabase::class.java, "links.db")
            .allowMainThreadQueries()
            .build()
    }

    fun getLinks(): List<Link> {
        return database.linkDao().getLinks()
    }

    private fun createNewLink(url: String): Link {
        return Link(url = url)
    }

    fun addLink(url: String): Link {
        val link: Link = createNewLink(url)
        database.linkDao().insertLink(link)
        return link
    }
}