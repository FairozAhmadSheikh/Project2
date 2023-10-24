package com.example.navigationapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.navigationapp.R

class Contact_us : Fragment() {

    private lateinit var submitButton: Button
    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var messageEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact_us, container, false)

        submitButton = view.findViewById(R.id.buttonSubmit)
        nameEditText = view.findViewById(R.id.editTextName)
        emailEditText = view.findViewById(R.id.editTextEmail)
        messageEditText = view.findViewById(R.id.editTextMessage)

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val message = messageEditText.text.toString()

            // Handle the data (e.g., send it to the server, perform validation, etc.)
            // For example, you can create a function to handle the submission
            // sendContactForm(name, email, message)

            Toast.makeText(requireContext(), "Thank you", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}
