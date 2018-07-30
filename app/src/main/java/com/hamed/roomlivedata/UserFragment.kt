package com.hamed.roomlivedatapaging


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamed.roomlivedatapaging.db.User
import kotlinx.android.synthetic.main.fragment_user.view.*


class UserFragment : Fragment() {
    private lateinit var mViewModel: UserViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = UserAdapter(activity!!)

        mViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        mViewModel.allUser.observe(this, Observer {
            adapter.submitList(it)
        })
        val rv = view.rv_user
        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(activity!!, LinearLayout.VERTICAL, false)
        rv.adapter = adapter

        view.btn_insert.setOnClickListener {
            val user = User(view.et_name.text.toString(), view.et_family.text.toString())
            mViewModel.insertUser(user)
        }
        view.btn_delete.setOnClickListener {
            val user = User(view.et_name.text.toString(), view.et_family.text.toString())
            mViewModel.deleteUser(view.et_name.text.toString())
        }

    }
}
