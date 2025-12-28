package com.braz.coderswag

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.braz.coderswag.Model.Category
import com.braz.coderswag.Services.DataService

class MainActivity : AppCompatActivity() {

    lateinit var adapter: ArrayAdapter<Category>
     lateinit var categoryListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, DataService.categories)

        categoryListView = findViewById(R.id.categoryListView)
        categoryListView.adapter = adapter


    }
}