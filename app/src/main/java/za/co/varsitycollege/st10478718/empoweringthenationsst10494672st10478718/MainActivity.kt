package za.co.varsitycollege.st10478718.empoweringthenationsst10494672st10478718

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
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
        val btnViewCourses = findViewById<Button>(R.id.btnViewCourses)
        val my_spinner = findViewById<Spinner>(R.id.my_spinner)

        btnViewCourses.setOnClickListener {
            val intent = Intent(this, CoursesScreen::class.java)
            startActivity(intent) // this button will allow the user to view the courses the program offers
        }
        val adapter= ArrayAdapter.createFromResource(
            this,
            R.array.dropdown_items, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            my_spinner.adapter = adapter
        }

        my_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            var isFirstSelection = true
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (isFirstSelection) {
                    isFirstSelection = false
                    return
                }
                when (position) {
                    0 -> startActivity(Intent(this@MainActivity, MainActivity:: class.java))
                    1 -> startActivity(Intent(this@MainActivity, CoursesScreen ::class.java))
                    2 -> startActivity(Intent(this@MainActivity, ShortCourses ::class.java))
                    3->  startActivity(Intent(this@MainActivity, FirstAid::class.java))
                    4->  startActivity(Intent(this@MainActivity, Sewing::class.java))
                    5->  startActivity(Intent(this@MainActivity, Landscaping::class.java))
                    6->  startActivity(Intent(this@MainActivity, LifeSkills::class.java))
                    7->  startActivity(Intent(this@MainActivity, ChildMinding::class.java))
                    8->  startActivity(Intent(this@MainActivity, Cooking::class.java))
                    9->  startActivity(Intent(this@MainActivity, GardernMaintence::class.java))
                    10-> startActivity(Intent(this@MainActivity, BookingScreen ::class.java))
                    11 -> startActivity(Intent(this@MainActivity, ThankyouScreen::class.java))
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>){
            }
        }
    }
    }