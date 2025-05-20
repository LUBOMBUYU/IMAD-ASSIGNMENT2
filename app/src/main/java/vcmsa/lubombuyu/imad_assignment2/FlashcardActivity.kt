package vcmsa.lubombuyu.imad_assignment2

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FlashcardActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Lock screen orientation to landscape
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        // Set the layout file for this screen
        setContentView(R.layout.activity_flashcard)

        // Link layout elements to variables
        val edtQuestions = findViewById<EditText>(R.id.edtQuestions)
        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val btnNext = findViewById<ImageButton>(R.id.btnINext)

        // Create the flashcard questions and answers
        // Questions where genereated by ChatGPT, Prompt: Please give me 5 true or false questions about Africa.
        val questions = arrayListOf(
            "The Great Zimbabwe ruins were built by the Shona people.",
            "Ethiopia was never colonized by a European power.",
            "The Atlantic slave trade ended in the 20th century.",
            "Nelson Mandela was imprisoned for 27 years.",
            "Mansa Musa was a ruler of the Mali Empire."
        )

        val answers = arrayListOf(
            true,   // Shona people
            true,   // Ethiopia not colonized
            false,  // Slave trade ended in 19th century
            true,   // Mandela: 27 years
            true    // Mansa Musa ruled Mali
        )

        // Create tracking lists for quiz state
        val usedQuestions = arrayListOf<String>()
        val usedAnswers = arrayListOf<Boolean>()
        val userAnswers = arrayListOf<Boolean>()

        // Start with the first question
        var currentQuestion = questions.removeAt(0)
        var currentAnswer = answers.removeAt(0)
        edtQuestions.setText(currentQuestion)

        // Set buttons state
        btnNext.isEnabled = false
        btnTrue.isEnabled = true
        btnFalse.isEnabled = true

        // Handle "True" answer
        btnTrue.setOnClickListener {
            userAnswers.add(true)
            usedQuestions.add(currentQuestion)
            usedAnswers.add(currentAnswer)

            // Show Toast
            if (true == currentAnswer) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Incorrect! Correct answer is False.", Toast.LENGTH_LONG)
                    .show()
            }

            btnTrue.isEnabled = false
            btnFalse.isEnabled = false
            btnNext.isEnabled = true
        }

        // Handle "False" answer
        btnFalse.setOnClickListener {
            userAnswers.add(false)
            usedQuestions.add(currentQuestion)
            usedAnswers.add(currentAnswer)

            // Show Toast
            if (false == currentAnswer) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Incorrect! Correct answer is True.", Toast.LENGTH_LONG).show()
            }

            btnTrue.isEnabled = false
            btnFalse.isEnabled = false
            btnNext.isEnabled = true
        }

        // Handle "Next" button click
        btnNext.setOnClickListener {
            if (questions.isNotEmpty()) {
                // Load next question directly
                currentQuestion = questions.removeAt(0)
                currentAnswer = answers.removeAt(0)

                edtQuestions.setText(currentQuestion)
                btnTrue.isEnabled = true
                btnFalse.isEnabled = true
                btnNext.isEnabled = false
            } else {
                // Quiz finished: calculate score
                var score = 0
                for (i in usedAnswers.indices) {
                    if (userAnswers[i] == usedAnswers[i]) {
                        score++
                    }
                }

                // Open ScoreActivity and send results
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("correct", score)
                intent.putExtra("total", usedAnswers.size)
                intent.putStringArrayListExtra("questions", usedQuestions)
                intent.putExtra("correctAnswers", usedAnswers.toBooleanArray())
                intent.putExtra("userAnswers", userAnswers.toBooleanArray())
                startActivity(intent)
                finish()

            }
        }
    }
}

