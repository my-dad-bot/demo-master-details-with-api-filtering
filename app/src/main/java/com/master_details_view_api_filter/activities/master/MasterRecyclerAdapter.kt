package com.master_details_view_api_filter.activities.master

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.master_details_view_api_filter.R
import com.master_details_view_api_filter.base.data.remote.FilteredMeal

class MasterRecyclerAdapter
constructor(
    private val context: Context,
    private var foodlist: ArrayList<FilteredMeal>
) : RecyclerView.Adapter<MasterRecyclerAdapter.MealViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return MealViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val user = userList[position]
        holder.name.text = user.name
        holder.age.text = user.age.toString()
    }

    override fun getItemCount(): Int = userList.size

    class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}
