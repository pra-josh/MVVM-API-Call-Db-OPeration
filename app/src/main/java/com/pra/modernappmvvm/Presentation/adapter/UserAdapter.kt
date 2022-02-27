package com.pra.modernappmvvm.Presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pra.modernappmvvm.Data.model.user.User
import com.pra.modernappmvvm.databinding.ItemCountryBinding
import com.bumptech.glide.Glide


class UserAdapter(private val context: Context,
                  private val userList: ArrayList<User>) :
    RecyclerView.Adapter<UserAdapter.MyViewHolder>() {


    fun UpdateCountry(newCountry: List<User>) {
        userList.clear()
        userList.addAll(newCountry)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding =
            ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(userList[position])

        Glide.with(context)
            .load("https://randomuser.me/api/portraits/thumb/women/43.jpg")
            .centerCrop()
            .into(holder.itemBinding.imageView);

    }

    override fun getItemCount(): Int = userList.size


    class MyViewHolder(public val itemBinding: ItemCountryBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(user: User) {
            itemBinding.tvUser.text = user.cell
            itemBinding.tvemail.text = user.email


        }
    }
}