package ch.ost.rj.mge.yaqs.model.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ch.ost.rj.mge.yaqs.model.Link

@Dao
interface LinkDao {
    @Query("SELECT * FROM links")
    fun getLinks(): List<Link>

    @Insert
    fun insertLink(link: Link)

}