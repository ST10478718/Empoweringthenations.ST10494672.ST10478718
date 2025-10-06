package za.co.varsitycollege.st10478718.empoweringthenationsst10494672st10478718

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ShortCourses : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_short_courses)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnBookCourse = findViewById<Button>(R.id.btnBookCourse)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBookCourse.setOnClickListener{
            val intent= Intent(this,BookingScreen::class.java)
            startActivity(intent) // the book button will allow the user do book their courses choices on the next page
        }

        btnBack.setOnClickListener {
            finish()// this button will allow the user to go back to the previous page.
        }
    }
}