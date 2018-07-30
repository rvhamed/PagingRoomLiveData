package com.hamed.roomlivedatapaging

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hamed.roomlivedatapaging.db.User
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(val context : Context) : PagedListAdapter <User,UserAdapter.UserViewHolder>(DIFF_CALLBACK()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.item_user,parent,false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val data = getItem(position)
        if (data!=null) {
            holder.text_name.text = data.name
            holder.text_family.text = data.family
        }

    }

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val text_name = view.text_name
        val text_family = view.text_family
    }

    companion object {
        fun DIFF_CALLBACK(): DiffUtil.ItemCallback<User>{
            return object : DiffUtil.ItemCallback<User>(){
                override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                    return oldItem.id == newItem.id
                }
                override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                    return oldItem==newItem
                }

            }
        }
    }

}