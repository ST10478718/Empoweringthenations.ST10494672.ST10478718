package za.co.varsitycollege.st10478718.empoweringthenationsst10494672st10478718

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculateFees : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculate_fees)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnNext = findViewById<Button>(R.id.btnNext)

        btnBack.setOnClickListener {
            finish()
        }// this button will take you back to the homepage and take you back to the previous page
        btnNext.setOnClickListener {
            val Intent = Intent(this, ThankyouScreen::class.java)
            startActivity(Intent)
        }

        val textViewSummary = findViewById<TextView>(R.id.textViewSummary)

        val longTermCount = intent.getIntExtra("longTermCount",0)
        val shortTermCount = intent.getIntExtra("shortTermCount",0)

        val longTermCost = 1500
        val shortTermCost = 750
        // declaring the constant numeric value for the long courses and the short courses.

        val totalCourses = longTermCount + shortTermCount
        val subtotal = (longTermCount * longTermCost) + (shortTermCount * shortTermCost)
        // equation to calculate the total number of courses and the subtotal the user
        // will pay before getting a discount depending on the courses selected.

                val discount = when (totalCourses){
                    2 -> 0.05
                    3 -> 0.10
                    4 -> 0.15
                    else -> 0.0
                } // the intializing when the discount should included in the calculation.
        val discountAmount = subtotal * discount
        val finalAmount = subtotal - discountAmount
        // equation for how much the user will pay including the discount

        val summaryText = """
        Long-term courses selected: $longTermCount
        Short-term courses selected: $shortTermCount

        Subtotal:R$subtotal
        Discount:${discount * 100}%
                Final Amount:R$finalAmount
                """.trimIndent()
        textViewSummary.text=summaryText
    } // this is how the summary text will be display to the user
}