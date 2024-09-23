package com.example.mobileassignment2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val spinner = findViewById<Spinner>(R.id.spinner)

        val majors = arrayOf("Choose a major", "Information Science", "Computer Science", "Math and CS", "Data Science", "Other");
        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, majors);

        val textView = findViewById<TextView>(R.id.textView);
        textView.text = "";

        val btn = findViewById<Button>(R.id.button);
        btn.setOnClickListener {
            val name = findViewById<TextView>(R.id.editTextText);
            val email = findViewById<TextView>(R.id.editTextTextEmailAddress);
            val password = findViewById<TextView>(R.id.editTextTextPassword2);
            val confirmPassword = findViewById<TextView>(R.id.editTextTextPassword3);

            var isValid = true
            if (name.text.isEmpty()) {
                name.error = "Please enter your name"
                isValid = false
            }
            if (email.text.isEmpty()) {
                email.error = "Please enter your email"
                isValid = false
            }
            if (spinner.selectedItemPosition == 0) {
                Toast.makeText(this, "Choose a Fuckin' major", Toast.LENGTH_SHORT).show()
                isValid = false
            }
            if (password.text.isEmpty()) {
                password.error = "Please enter a password"
                isValid = false
            }
            if (confirmPassword.text.isEmpty()) {
                confirmPassword.error = "Please confirm your password"
                isValid = false
            } else if (password.text.toString() != confirmPassword.text.toString()) {
                confirmPassword.error = "Passwords do not match"
                isValid = false
            }

            if (isValid)
                textView.text = "Welcome to the App, ${name.text}!"
        }
    }
}