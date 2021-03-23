package com.example.timestest.data.model

import android.os.Parcelable
import androidx.room.*
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
@Entity(tableName = "NewsfeedItem")
data class NewsfeedItem(
        @PrimaryKey @ColumnInfo(name = "id") var id: Long,
        @ColumnInfo(name = "uri") var uri: String,
        @ColumnInfo(name = "url") var url: String,
        @ColumnInfo(name = "source") var source: String,
        @ColumnInfo(name = "title") var title: String,
        @ColumnInfo(name = "abstract") @Json(name = "abstract") var itemAbstract: String,
        @ColumnInfo(name = "media") var media: @RawValue List<NewsfeedItemMedia>
): Parcelable {
    val imageUrl: String get() {
        this.media.firstOrNull()?.let {
            val mediumImage = it.mediaMetadata.get(1)
            return mediumImage.url
        }
        return ""
    }

    val imageUrlLarge: String get() {
        this.media.firstOrNull()?.let {
            val mediumImage = it.mediaMetadata.get(2)
            return mediumImage.url
        }
        return ""
    }
}