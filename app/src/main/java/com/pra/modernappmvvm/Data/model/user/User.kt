package com.pra.modernappmvvm.Data.model.user


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo()
    var id:Int? = null,

    @SerializedName("cell")
    @ColumnInfo()
    var cell: String,

    @SerializedName("email")
    @ColumnInfo()
    var email: String,

    @SerializedName("gender")
    @ColumnInfo()
    var gender: String,

    /*@SerializedName("name")
    var name: Name,
    */
    @SerializedName("phone")
    @ColumnInfo()
    var phone: String,
    /*@SerializedName("picture")
    var picture: Picture,
*/
  /*  @ColumnInfo(name ="image_url")
    var image_url: String,

    @ColumnInfo(name = "nameDb")
    var nameDb: String,*/
)