package com.example.androidproject.restaurants.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidproject.R
import com.example.androidproject.models.Restaurant
import kotlinx.android.synthetic.main.item_restaurants.view.*

class RestaurantsAdapter(private val restaurantList: List<Restaurant>) : RecyclerView.Adapter<RestaurantsAdapter.RestaurantsViewHolder>() {

    class RestaurantsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.item_restaurants_image
        val titleView: TextView = itemView.item_restaurants_title
        val locationView: TextView = itemView.item_restaurants_location
        val priceView: TextView = itemView.item_restaurants_price
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurants, parent, false)
        return RestaurantsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        val currentItem = restaurantList[position]

        Glide
            .with(holder.itemView)
            .load(currentItem.image_url)
            .placeholder(R.drawable.ic_time_280px)
            .fallback(R.drawable.ic_not_280px)
            .override(280, 280)
            .fitCenter()
            .into(holder.imageView)
        holder.titleView.text = if (currentItem.name.length > 25) currentItem.name.substring(0, 25) + "..."
            else currentItem.name
        holder.locationView.text = if (currentItem.getLocation().length > 30) currentItem.getLocation().substring(0, 30) + "..."
            else currentItem.getLocation()
        holder.priceView.text = "Price - ${currentItem.price}"
    }

    override fun getItemCount(): Int = restaurantList.size

}