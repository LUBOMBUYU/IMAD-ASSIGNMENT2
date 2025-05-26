package vcmsa.lubombuyu.imad_assignment2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

class CountdownActivity : AppCompatActivity() {

    private lateinit var countdownText: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_countdown)
        val root = window.decorView
        countdownText = findViewById(R.id.cdTxt1)
        ViewCompat.setOnApplyWindowInsetsListener(root) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }
        // Code starts here
        // Color mapping for each number
        val colorMap = mapOf(
            5 to R.color.count5,
            4 to R.color.count4,
            3 to R.color.count3,
            2 to R.color.count2,
            1 to R.color.count1
        )

        var current = 6
        // Code was made by chatgpt
        // Set initial state before countdown begins
        countdownText.text = current.toString()
        root.setBackgroundColor(ContextCompat.getColor(this, colorMap[current] ?: R.color.count1))

        // Start the countdown
        object : CountDownTimer(6_000L, 1_000L) {

            override fun onTick(millisUntilFinished: Long) {
                current--
                if (current >= 0) {
                    countdownText.text = current.toString()
                    val colorRes = colorMap[current] ?: R.color.count1
                    root.setBackgroundColor(ContextCompat.getColor(this@CountdownActivity, colorRes))
                }
            }

            override fun onFinish() {
                // Show "Go!" with animation
                countdownText.text = "Go!"
                countdownText.alpha = 0f
                countdownText.animate().alpha(1f).setDuration(500).start()

                root.setBackgroundColor(ContextCompat.getColor(this@CountdownActivity, R.color.goColor))

                // Transition to next screen after 1 second
                countdownText.postDelayed({
                    startActivity(Intent(this@CountdownActivity, FlashcardActivity::class.java))
                    finish()
                }, 1000)
            }
        }.start()
    }
}
