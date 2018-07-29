package com.hamed.roomlivedata.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert fun insertUser(user:List<User>)
    @Insert fun insertUser(user:User)

    @Delete fun deleteUser(user:List<User>)
    @Delete fun deleteUser(user:User)

    @Query("DELETE FROM user WHERE name LIKE :name")fun deleteUser(name : String)
    @Query("SELECT * FROM user") fun getAllUser() : LiveData<List<User>>
}