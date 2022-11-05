package ch.ost.rj.mge.yaqs.model

import android.content.Context
import ch.ost.rj.mge.yaqs.model.storage.LinkDatabase

object LinkRepository {
    private lateinit var database: LinkDatabase

    fun initialize(context: Context) {
        database = LinkDatabase.getDatabase(context)
    }

    fun getLinks(): List<Link> {
        return database.linkDao().getLinks()
    }

    private fun createNewLink(time: Long, url: String): Link {
        return Link(url = url, time = time)
    }

    fun addLink(time: Long, url: String): Link {
        val link: Link = createNewLink(time, url)
        database.linkDao().insertLink(link)
        return link
    }

    fun deleteLink(link: Link) {
        database.linkDao().deleteLink(link)
    }
}