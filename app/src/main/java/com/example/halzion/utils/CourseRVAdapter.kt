package com.example.halzion.utils

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.halzion.R
import androidx.recyclerview.widget.RecyclerView
import com.example.halzion.activities.DetailActivity
import com.example.halzion.activities.ProfileActivity
import com.example.halzion.activities.RateActivity
import com.example.halzion.activities.SettingsActivity

// on below line we are creating
// a course rv adapter class.
class CourseRVAdapter(
    // on below line we are passing variables
    // as course list and context
    private val courseList: ArrayList<CourseRVModal>,
    private val context: Context
) : RecyclerView.Adapter<CourseRVAdapter.CourseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseRVAdapter.CourseViewHolder {
        // this method is use to inflate the layout file
        // which we have created for our recycler view.
        // on below line we are inflating our layout file.
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.course_rv_item,
            parent, false
        )
        // at last we are returning our view holder
        // class with our item View File.
        return CourseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CourseRVAdapter.CourseViewHolder, position: Int)  {

        val course = courseList[position]
        holder.courseNameTV.text = course.courseName
        // on below line we are setting data to our text view and our image view.
        holder.courseNameTV.text = courseList.get(position).courseName
        holder.courseIV.setImageResource(courseList.get(position).courseImg)

        holder.itemView.setOnClickListener {
            if (course.courseName == "Android Development") {
                val intent = Intent(context, DetailActivity::class.java)
                context.startActivity(intent)
            }
            if (course.courseName == "Dev Profile") {
                val intent = Intent(context, ProfileActivity::class.java)
                context.startActivity(intent)
            }
            if (course.courseName == "Settings") {
                val intent = Intent(context, SettingsActivity::class.java)
                context.startActivity(intent)
            }
            if (course.courseName == "Rate This App") {
                val intent = Intent(context, RateActivity::class.java)
                context.startActivity(intent)
            }
        }


    }



    override fun getItemCount(): Int {
        // on below line we are
        // returning our size of our list
        return courseList.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing our course name text view and our image view.
        val courseNameTV: TextView = itemView.findViewById(R.id.idTVCourse)
        val courseIV: ImageView = itemView.findViewById(R.id.idIVCourse)
    }
}