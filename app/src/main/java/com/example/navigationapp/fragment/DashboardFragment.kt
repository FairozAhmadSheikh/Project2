package com.example.navigationapp.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationapp.R
import com.example.navigationapp.adapter.DashboardRecyclerAdapter

class DashboardFragment : Fragment() {
    lateinit var recyclerDashboard:RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    val placeslist= arrayListOf<String>("Hello1","Hello2","Hello3","Hello4","Hello5",
        "Hello6","Hello7","Hello8","Hello9","Hello10")
     lateinit var recyclerAdapter: DashboardRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_dashboard, container, false)

        recyclerDashboard=view.findViewById(R.id.recyclerDashboard)
        layoutManager=LinearLayoutManager(activity)
        recyclerAdapter= DashboardRecyclerAdapter(activity as Context,placeslist)
        recyclerDashboard.adapter=recyclerAdapter
        recyclerDashboard.layoutManager=layoutManager
        return view
    }
}
