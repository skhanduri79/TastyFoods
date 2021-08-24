package com.example.sakshi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sakshi.R
import com.example.sakshi.model.Restaurant

class DashboardRecyclerAdapter(val context:Context, private val restaurantList:ArrayList<Restaurant>):
    RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {

    class DashboardViewHolder(view: View): RecyclerView.ViewHolder(view){

        val txtRestroName:TextView= view.findViewById(R.id.txtRestroName)
        val txtRestroDish:TextView=view.findViewById(R.id.txtRestroDish)
        val txtDishPrice:TextView=view.findViewById(R.id.txtDishPrice)
        val txtRestroRating:TextView=view.findViewById(R.id.txtRestroRating)
        val imgRestroImage:ImageView=view.findViewById(R.id.imgRestroImage)
        val llContent: LinearLayout =view.findViewById(R.id.llContent)

    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {

        val restaurant=restaurantList[position]
        holder.txtRestroName.text=restaurant.restroName
        holder.txtRestroDish.text=restaurant.dishPrice
        holder.txtDishPrice.text=restaurant.dishPrice
        holder.txtRestroRating.text=restaurant.restroRating
        holder.imgRestroImage.setBackgroundResource(restaurant.restroImage)

        holder.llContent.setOnClickListener{
            Toast.makeText(context,"clicked on ${holder.txtRestroName.text}",Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {

        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)
        return DashboardViewHolder(
            view
        )
    }
}
