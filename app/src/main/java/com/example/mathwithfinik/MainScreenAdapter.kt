package com.example.mathwithfinik

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MainScreenAdapter(private val menuItems: ArrayList<MenuItem>) :
    RecyclerView.Adapter<MainScreenAdapter.MainScreenViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainScreenViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.msf_item, parent, false)
        return MainScreenViewHolder(view)
    }

    override fun getItemCount(): Int = menuItems.size

    override fun onBindViewHolder(holder: MainScreenViewHolder, position: Int) {
        val item = menuItems[position]
        if (item.blocked == true) {
            holder.msfItemImage.setImageDrawable(item.icon)
            holder.msfNameTv.text = "Функціонал наразі у розробці"
        } else {
            holder.msfItemImage.setImageDrawable(item.icon)
            holder.msfNameTv.text = item.name
        }

    }

    class MainScreenViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val msfItemImage: ImageView = v.findViewById(R.id.msf_item_image)
        val msfNameTv: TextView = v.findViewById(R.id.msf_tv)
        val itemLayout: ConstraintLayout = v.findViewById(R.id.item_layout)
        fun isLocked() {
   //         msfItemImage.setImageDrawable(R.drawable.icon_lock)
        }
    }
}