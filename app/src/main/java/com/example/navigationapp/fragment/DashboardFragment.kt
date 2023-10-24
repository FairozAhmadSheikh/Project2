package com.example.navigationapp.fragment

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.navigationapp.R
import com.example.navigationapp.adapter.DashboardRecyclerAdapter
import model.Place
import util.ConnectionManager

class DashboardFragment : Fragment() {
    lateinit var recyclerDashboard:RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var internetcheckbutton:Button
    val placeslist= arrayListOf<String>("Gulmarg","Pehlgaaam","Aharbal","Sonmarg","Harwan",
        "Nishat","Shalimar","Badamwari","Achbal","Aawreyn")
     lateinit var recyclerAdapter: DashboardRecyclerAdapter
     val tourlistinfo= arrayListOf<Place>(
         Place("Gulmarg","Zaffer Ali","500","4.5",R.drawable.gulmarg),
         Place("Pehlgaam","Feroz","2500","4.3",R.drawable.pehlgam),
         Place("Aharbal","Abrar","1500","4.2",R.drawable.arhbal),
         Place("Sonmarg","Farhan","800","4.1",R.drawable.sonmarg),
         Place("Harwan","Abid","900","4.9",R.drawable.gulmarg),
         Place("Nishat","Muslim","600","3.5",R.drawable.gulmarg),
         Place("Shalimar","Musa","300","4.6",R.drawable.gulmarg),
         Place("Badamwari","Meesam","200","4.7",R.drawable.gulmarg),
         Place("Achbal","Aadil","400","4.8",R.drawable.gulmarg),
         Place("Aawreyn","Muzaffar","100","5",R.drawable.gulmarg)


     )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_dashboard, container, false)

        recyclerDashboard=view.findViewById(R.id.recyclerDashboard)
        layoutManager=LinearLayoutManager(activity)
        recyclerAdapter= DashboardRecyclerAdapter(activity as Context,tourlistinfo)
        recyclerDashboard.adapter=recyclerAdapter
        recyclerDashboard.layoutManager=layoutManager


        //Internet checker goes here
        internetcheckbutton=view.findViewById(R.id.internetcheckbuttton)
        internetcheckbutton.setOnClickListener {
            if (ConnectionManager().checkConnectivity(activity as Context)) {
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Success")
                dialog.setMessage("Internet is Active")
                dialog.setPositiveButton("OK") { _, _ ->
                    // Positive button click listener code goes here
                    // This block will be executed when the user clicks the "OK" button
                }
                dialog.setNegativeButton("Cancel") { _, _ ->
                    // Negative button click listener code goes here
                    // This block will be executed when the user clicks the "Cancel" button
                }
                dialog.create()
                dialog.show()
            } else {
                val dialog = AlertDialog.Builder(activity as Context)
                dialog.setTitle("Failed")
                dialog.setMessage("Internet is Not Active")
                dialog.setPositiveButton("OK") { _, _ ->
                    // Positive button click listener code goes here
                    // This block will be executed when the user clicks the "OK" button
                }
                dialog.setNegativeButton("Cancel") { _, _ ->
                    // Negative button click listener code goes here
                    // This block will be executed when the user clicks the "Cancel" button
                }
                dialog.create()
                dialog.show()
            }
        }



        // This adds line after view item completes
        recyclerDashboard.addItemDecoration(DividerItemDecoration(recyclerDashboard.context,(layoutManager as LinearLayoutManager).orientation))
        return view
    }
}
