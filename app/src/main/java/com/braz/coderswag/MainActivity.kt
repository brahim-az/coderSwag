package com.braz.coderswag

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.braz.coderswag.Adapters.CategoryRecycleAdapter
import com.braz.coderswag.Services.DataService

class MainActivity : AppCompatActivity() {

    lateinit var adapter: CategoryRecycleAdapter
     lateinit var categoryListView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        adapter = CategoryRecycleAdapter(this, DataService.categories)

        categoryListView = findViewById(R.id.categoryListView)
        categoryListView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)






    }
}