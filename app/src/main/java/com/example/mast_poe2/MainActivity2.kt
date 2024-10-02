package com.example.mast_poe2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.mast_poe2.R

class MainActivity2 : AppCompatActivity() {

    private val menuItems = mutableListOf<MenuItem>()
    private lateinit var itemList: ListView
    private lateinit var itemCount: TextView
    private lateinit var dishNameEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var priceEditText: EditText
    private lateinit var courseSpinner: Spinner

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        itemList = findViewById(R.id.itemList)
        itemCount = findViewById(R.id.itemCount)
        dishNameEditText = findViewById(R.id.dishName)
        descriptionEditText = findViewById(R.id.description)
        priceEditText = findViewById(R.id.price)
        courseSpinner = findViewById(R.id.courseSpinner)

        val courses = arrayOf("Select Course", "Starters", "Mains", "Desserts")
        courseSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, courses)

        findViewById<Button>(R.id.addButton).setOnClickListener { addMenuItem() }
    }

    private fun addMenuItem() {
        val dishName = dishNameEditText.text.toString()
        val description = descriptionEditText.text.toString()
        val price = priceEditText.text.toString().toDoubleOrNull()
        val course = courseSpinner.selectedItem.toString()

        if (dishName.isNotEmpty() && description.isNotEmpty() && price != null && course != "Select Course") {
            menuItems.add(MenuItem(dishName, description, price, course))
            updateMenuList()
            clearInputs()

            // Show a toast when the item is successfully added to the menu
            Toast.makeText(this, "Item added to menu", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateMenuList() {
        itemCount.text = "Total Menu Items: ${menuItems.size}"
        itemList.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, menuItems)
    }

    private fun clearInputs() {
        dishNameEditText.text.clear()
        descriptionEditText.text.clear()
        priceEditText.text.clear()
        courseSpinner.setSelection(0)
    }
}

data class MenuItem(val name: String, val description: String, val price: Double, val course: String)