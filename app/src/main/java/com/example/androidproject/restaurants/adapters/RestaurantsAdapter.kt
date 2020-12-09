package com.example.androidproject.restaurants.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidproject.R
import com.example.androidproject.models.Restaurant
import kotlinx.android.synthetic.main.item_restaurants.view.*

class RestaurantsAdapter(private val restaurantList: List<Restaurant>) : RecyclerView.Adapter<RestaurantsAdapter.RestaurantsViewHolder>() {

    class RestaurantsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.item_restaurants_image
        val titleView: TextView = itemView.item_restaurants_title
        val descriptionView: TextView = itemView.item_restaurants_description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurants, parent, false)
        return RestaurantsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        val currentItem = restaurantList[position]

        holder.titleView.text = currentItem.title
        holder.descriptionView.text = currentItem.description
    }

    override fun getItemCount(): Int = restaurantList.size

}