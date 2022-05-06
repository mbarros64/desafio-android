package com.picpay.desafio.android.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.picpay.desafio.android.models.User
import com.picpay.desafio.android.utils.UserListDiffCallback

class UserListAdapter(
    private val users: ArrayList<User> = arrayListOf()
) : RecyclerView.Adapter<UserListBindingHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserListBindingHolder(
        ListItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: UserListBindingHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount() = users.size

    fun updateUsers(newUsers: List<User>) {
        val diffResult = DiffUtil.calculateDiff(UserListDiffCallback(users, newUsers))

        users.clear()
        users.addAll(newUsers)

        diffResult.dispatchUpdatesTo(this)
    }
}