package vcmsa.lubombuyu.imad_assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.pm.ActivityInfo

class ScoreActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Code Starts Here
        // Retrieve the score and total number of questions from the intent
        val correct = intent.getIntExtra("correct", 0) // Number of correct answers
        val total = intent.getIntExtra("total", 0)     // Total questions
        val percentage = if (total > 0) (correct * 100) / total else 0 // Calculate percentage score

        // Declare all variables
        val tvFinalScore = findViewById<TextView>(R.id.tvFinalScore)
        val tvPercentage = findViewById<TextView>(R.id.tvPercentage)
        val tvFeedback = findViewById<TextView>(R.id.tvFeedback)
        val btnRetake = findViewById<Button>(R.id.btnRetake)
        val btnExit = findViewById<Button>(R.id.btnExit)

        // Display the score and percentage to the user
        tvFinalScore.text = "Score: $correct/$total"
        tvPercentage.text = "Percentage: $percentage%"

        // Display feedback based on performance
        tvFeedback.text = when {
            percentage == 100 -> "Perfect score! Well done!"                   // 100%
            percentage >= 80 -> "Great job! Keep it up!"                      // 80%–99%
            percentage >= 50 -> "Good effort, but review your mistakes."      // 50%–79%
            else -> "Keep practicing!"                                        // Below 50%
        }

        // Button to review answers for user
        val btnReview = findViewById<Button>(R.id.btnReview)
        btnReview.setOnClickListener {
            val correctAnswers = intent.getBooleanArrayExtra("correctAnswers")

            if (correctAnswers != null) {
                val toastMessage = StringBuilder()
                for (i in correctAnswers.indices) {
                    val answerText = if (correctAnswers[i]) "true" else "false"
                    toastMessage.append("Q${i + 1}. is $answerText, ")
                }

                // Trim the last comma and space
                val finalMessage = toastMessage.toString().trim().removeSuffix(",")

                Toast.makeText(this, finalMessage, Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No answers to review.", Toast.LENGTH_SHORT).show()
            }
        }

        // When "Retake" is clicked, restart the quiz by launching FlashcardActivity
        btnRetake.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Close the current screen
        }

        // When "Exit" is clicked, close the entire app
        btnExit.setOnClickListener {
            finishAffinity() // Exits the app completely
        }
    }
}
