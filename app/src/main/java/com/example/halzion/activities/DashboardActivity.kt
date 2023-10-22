package com.example.halzion.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.halzion.R
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.halzion.utils.CourseRVAdapter
import com.example.halzion.utils.CourseRVModal

class DashboardActivity : AppCompatActivity() {
    // on below line we are creating variables
    // for our swipe to refresh layout,
    // recycler view, adapter and list.
    lateinit var courseRV: RecyclerView
    lateinit var courseRVAdapter: CourseRVAdapter
    lateinit var courseList: ArrayList<CourseRVModal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // on below line we are initializing
        // our views with their ids.
        courseRV = findViewById(R.id.idRVCourses)

        // on below line we are initializing our list
        courseList = ArrayList()

        // on below line we are creating a variable
        // for our grid layout manager and specifying
        // column count as 2
        val layoutManager = GridLayoutManager(this, 2)

        courseRV.layoutManager = layoutManager

        // on below line we are initializing our adapter
        courseRVAdapter = CourseRVAdapter(courseList, this)

        // on below line we are setting
        // adapter to our recycler view.
        courseRV.adapter = courseRVAdapter

        // on below line we are adding data to our list
        courseList.add(CourseRVModal("Android Development", R.drawable.android))
        courseList.add(CourseRVModal("C++ Development", R.drawable.c))
        courseList.add(CourseRVModal("Rate This App", R.drawable.ic_baseline_star_rate_24))
        courseList.add(CourseRVModal("Settings", R.drawable.ic_baseline_settings_24))
        courseList.add(CourseRVModal("Dev Profile", R.drawable.avatar))

        // on below line we are notifying adapter
        // that data has been updated.
        courseRVAdapter.notifyDataSetChanged()

    }
}