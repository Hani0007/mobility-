package com.example.application

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class homescreen : AppCompatActivity() {
    private lateinit var Accesibility : Button
    private lateinit var Maps: Button
    private lateinit var Report_Accessibility : Button
    lateinit var sigin : Button
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_homescreen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            sigin = findViewById(R.id.button)
            Accesibility = findViewById(R.id.button3)
            Maps = findViewById(R.id.button2)
            Report_Accessibility= findViewById(R.id.button4)
            sigin.setOnClickListener{
                val intent = Intent(this, contactinfo::class.java)
                startActivity(intent)
            }
            Accesibility.setOnClickListener{
                val intent = Intent(this, accesibilityissues::class.java)
                startActivity(intent)
            }
            Maps.setOnClickListener{
                val intent = Intent(this, search::class.java)
                startActivity(intent)
            }



            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

    }


}

