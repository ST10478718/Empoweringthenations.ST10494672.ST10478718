package za.co.varsitycollege.st10478718.empoweringthenationsst10494672st10478718

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.jar.Attributes

class BookingScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_booking_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnBook = findViewById<Button>(R.id.btnBook)
        val txtName = findViewById<EditText>(R.id.txtName)
        val txtPhone = findViewById<EditText>(R.id.txtPhone)
        val txtEmail = findViewById<EditText>(R.id.txtEmail)
        val btnBack= findViewById<Button>(R.id.btnBack)


        btnBook.setOnClickListener{

            val intent= Intent( this,ThankyouScreen::class.java)
            startActivity(intent) // this button will take the user to the next page, // this button will also pass on the entered information
        }
        btnBack.setOnClickListener {
            finish()// this button will allow the user to go back to the previous page.
        }
        if(txtName.text.toString().trim().isEmpty()){
            txtName.error = "This field cannot be empty"
            return
        }
        if(txtPhone.text.toString().trim().isEmpty()){
            txtPhone.error = "This field cannot be empty"
            return
        }
        if(txtEmail.text.toString().trim().isEmpty()){
            txtEmail.error = "This field cannot be empty"
            return
        }



    }
}


