package vcmsa.lubombuyu.assignment2prac

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import vcmsa.lubombuyu.imad_assignment2.FlashcardActivity
import vcmsa.lubombuyu.imad_assignment2.R

class CountdownActivity : AppCompatActivity() {

    private lateinit var root: View
    private lateinit var countdownText: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_countdown)

        // Find views
        val main = 0
        root = findViewById(main)
        countdownText = findViewById(R.id.cdTxt1)

        // Apply window insets as padding
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }
        // Code was taken from chatGPT, Prompt: i want to create a countdown for my app and it should
        // change colour for each number decreasing
        // Define your color mapping (5→1)
        val colorMap = mapOf(
            5 to R.color.count5,
            4 to R.color.count4,
            3 to R.color.count3,
            2 to R.color.count2,
            1 to R.color.count1
        )

        // Start a 5-second countdown (tick every 1s)
        object : CountDownTimer(6_000L, 1_000L) {
            var current = 5

            override fun onTick(millisUntilFinished: Long) {
                // Update text
                countdownText.text = current.toString()
                // Change background color
                val colorRes = colorMap[current] ?: R.color.count5
                root.setBackgroundColor(ContextCompat.getColor(this@CountdownActivity, colorRes))
                current--
            }

            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                // Show “Go!” in amber
                countdownText.text = "Go!"
                root.setBackgroundColor(
                    ContextCompat.getColor(this@CountdownActivity, R.color.goColor)
                )
                // Pause briefly, then move on
                countdownText.postDelayed({
                    // Example: launch FlashcardActivity
                    startActivity(Intent(this@CountdownActivity, FlashcardActivity::class.java))
                    finish()
                }, 100)
            }
        }.start()
    }
}
