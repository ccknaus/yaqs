package ch.ost.rj.mge.yaqs.model.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ch.ost.rj.mge.yaqs.model.Link

@Dao
interface LinkDao {
    @Query("SELECT * FROM links ORDER BY time DESC")
    fun getLinks(): List<Link>

    @Insert
    fun insertLink(link: Link)

    @Delete
    fun deleteLink(link: Link)
}