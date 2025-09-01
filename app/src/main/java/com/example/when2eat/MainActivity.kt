package com.example.when2eat

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    //Search and Buttons
    private lateinit var timeOfDaySearch: EditText
    private lateinit var searchButton: Button
    private lateinit var resetButton: Button

    // Food Suggestions
    private lateinit var foodSuggestion: TextView
    //Author: Zahra Bulbulia
    //Url: https://www.youtube.com/watch?v=97n4_oWyxg4


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //Naming elements
        //Search and Buttons
        timeOfDaySearch = findViewById(R.id.timeOfDaySearch)
        searchButton = findViewById(R.id.searchButton)
        resetButton = findViewById(R.id.resetButton)

        //Food Suggestions
        foodSuggestion = findViewById(R.id.foodSuggestion)
        //Author: Zahra Bulbulia
        //Url: https://www.youtube.com/watch?v=R5p-YXC87VU


        //Adding functionality
        //Search button
        searchButton.setOnClickListener {
            val timeOfDaySearch = timeOfDaySearch.text.toString().trim()
            val suggestionInfo = when (timeOfDaySearch.lowercase()) {
                //food suggestions according to time of day
                "morning" -> "Almond-Buckwheat Granola with Yogurt and Berries"
                "mid-morning" -> "Almond-Chia Energy Bites"
                "afternoon" -> "Chilli Cheese McFlavour Fries"
                "mid-afternoon" -> "Caramel Popcorn"
                "dinner" -> "Hawaiian Pizza"
                "after-dinner" -> "Chocolate Mousse"

                //Display error if no time of day was entered
                else -> "Enter a valid time of day using lowercase (e.g. morning, mid-afternoon, after-dinner)."
                //Author: Zahra Bulbulia
                //Url: https://www.youtube.com/watch?v=R5p-YXC87VU
            }
            foodSuggestion.text = suggestionInfo
            //Author: Zahra Bulbulia
            //Url: https://www.youtube.com/watch?v=R5p-YXC87VU

        }

        //Reset Button
        resetButton.setOnClickListener {
            //clear EditText
            timeOfDaySearch.text.clear()
            //remove the food suggestion TextView
            foodSuggestion.text = ""
            //Author: Zahra Bulbulia
            //Url: https://www.youtube.com/watch?v=R5p-YXC87VU
        }
    }
}