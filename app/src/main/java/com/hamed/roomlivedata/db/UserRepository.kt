package com.hamed.roomlivedata.db

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class UserRepository(var application: Application) {

    fun userdb() = UserRoomDatabase.getDatabase(application)
    fun userDao() = userdb().userDao()

    companion object {

        class InsertUser(val dao: UserDao):AsyncTask<User,Void?,Void?>(){
            override fun doInBackground(vararg p0: User?): Void? {
                dao.insertUser(p0[0]!!)
                return null
            }
        }
        class DeleteUser(val dao: UserDao):AsyncTask<String,Void?,Void?>(){
            override fun doInBackground(vararg p0: String?): Void? {
                dao.deleteUser(p0[0]!!)
                return null
            }

        }
    }


    fun insertUser(user:User){
        InsertUser(userDao()).execute(user)
    }

    fun deleteUser(name: String){
        DeleteUser(userDao()).execute(name)
    }

    fun getAllUser(): LiveData<List<User>>{
        return userDao().getAllUser()
    }
}