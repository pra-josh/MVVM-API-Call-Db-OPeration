package com.pra.modernappmvvm.Data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pra.modernappmvvm.Data.model.user.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(userList: List<User>)

    @Query("DELETE from user_table")
    suspend fun deleteAllUser()

    @Query("SELECT * from user_table")
    suspend fun getAllUser(): List<User>

}