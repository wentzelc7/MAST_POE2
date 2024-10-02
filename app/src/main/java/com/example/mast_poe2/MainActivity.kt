package com.example.mast_poe2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mast_poe2.MainActivity2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val buttonNavigate = findViewById<Button>(R.id.button2)

        buttonNavigate.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
    }
}