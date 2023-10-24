package com.example.navigationapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationapp.R
import model.Place

class DashboardRecyclerAdapter(val context: Context, val itemList:ArrayList<Place>):RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {
    class DashboardViewHolder(view:View):RecyclerView.ViewHolder(view){
        val textview:TextView=view.findViewById(R.id.txtRecyclerRowItem)
        val placename:TextView=view.findViewById(R.id.txtRecyclerRowItem)
        val price:TextView=view.findViewById(R.id.txtBookPrice)
        val rating:TextView=view.findViewById(R.id.txtBookRating)
        val guidename:TextView=view.findViewById(R.id.txtBookAuthor)
        val imagebackground:ImageView=view.findViewById(R.id.tourplaceimage)
        // Making view item clickable here
        val parentviewlayout:LinearLayout=view.findViewById(R.id.parentviewlayout)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)
    return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
     val place=itemList[position]
        holder.placename.text=place.tourplacename
        holder.price.text=place.tourcost
        holder.rating.text=place.tourplacerating
        holder.guidename.text=place.tourguide
        holder.imagebackground.setImageResource(place.tourplaceImage)
        // setting on click listner in a row
        holder.parentviewlayout.setOnClickListener{
            Toast.makeText(context,"Clicked on ${holder.placename.text}",Toast.LENGTH_SHORT).show()
        }


    }
}