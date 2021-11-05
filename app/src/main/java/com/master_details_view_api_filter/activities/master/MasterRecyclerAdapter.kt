package com.master_details_view_api_filter.activities.master

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.master_details_view_api_filter.R
import com.master_details_view_api_filter.activities.food_details.ui.FoodDetailsActivity
import com.master_details_view_api_filter.base.data.remote.FilteredMeal
import com.master_details_view_api_filter.utils.load

class MasterRecyclerAdapter(
    private val context: Context,
    private var foodlist: FilteredMeal
) : RecyclerView.Adapter<MasterRecyclerAdapter.MealViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return MealViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.textView.text = foodlist.meals[position].strMeal
        holder.imageView.load(foodlist.meals[position].strMealThumb)
        holder.cardView.setOnClickListener {
            Intent(context, FoodDetailsActivity::class.java).apply {
                putExtra("meal_id", foodlist.meals[position].idMeal)
                context.startActivity(this)
            }
        }

    }

    override fun getItemCount(): Int = foodlist.meals.size

    class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageFood)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val cardView: CardView = itemView.findViewById(R.id.card_view)
    }

}
