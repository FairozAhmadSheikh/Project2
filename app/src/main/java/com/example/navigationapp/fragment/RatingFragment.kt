package com.example.navigationapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.Toast
import com.example.navigationapp.R

class RatingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rating, container, false)

        val submitButton = view.findViewById<Button>(R.id.submitButton)
        val ratingBar = view.findViewById<RatingBar>(R.id.ratingBar)

        submitButton.setOnClickListener {
            val rating = ratingBar.rating
        Toast.makeText(requireContext(),"Thank you",Toast.LENGTH_SHORT).show()
        }

        return view
    }
}