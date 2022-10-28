package ch.ost.rj.mge.yaqs.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "links")
data class Link(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "link")
    val url: String,

    @ColumnInfo(name = "time")
    val time: Long
)