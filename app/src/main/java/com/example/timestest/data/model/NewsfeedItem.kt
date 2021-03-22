package com.example.timestest.data.model

import androidx.room.*
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import java.util.*

@Entity(tableName = "NewsfeedItem")
data class NewsfeedItem(
    @PrimaryKey @ColumnInfo(name = "id") var id: Long,
    @ColumnInfo(name = "uri") var uri: String,
    @ColumnInfo(name = "url") var url: String,
    @ColumnInfo(name = "source") var source: String,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "media") var media: List<NewsfeedItemMedia>
) {
    val imageUrl: String get() {
        this.media.firstOrNull()?.let {
            val mediumImage = it.mediaMetadata.get(1)
            return mediumImage.url
        }
        return ""
    }
}