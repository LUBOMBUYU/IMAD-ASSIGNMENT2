package vcmsa.lubombuyu.assignment2prac

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Draw behind status & nav bars
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.start_main)

        // Apply safe area insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 🔹 Find views
        val startButton = findViewById<Button>(R.id.btnStart)
        val infoButton = findViewById<ImageButton>(R.id.imageButton)

        // 🔹 Handle Start Button click → Go to CountdownActivity
        startButton.setOnClickListener {
            val intent = Intent(this, CountdownActivity::class.java)
            startActivity(intent)
        }

        // 🔹 Handle Info Button click → Show app description
        infoButton.setOnClickListener {
            Toast.makeText(
                this,
                "History Flash: Test your African history knowledge with quick true/false questions!",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
