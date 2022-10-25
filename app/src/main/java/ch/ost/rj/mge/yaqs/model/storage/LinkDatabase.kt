package ch.ost.rj.mge.yaqs.model.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import ch.ost.rj.mge.yaqs.model.Link

@Database(entities = [Link::class], version = 1, exportSchema = false)
abstract class LinkDatabase: RoomDatabase() {
    abstract fun linkDao(): LinkDao
}