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
import vcmsa.lubombuyu.imad_assignment2.CountdownActivity
import vcmsa.lubombuyu.imad_assignment2.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Code Start Here
        // Inputting values to variables
        val startButton = findViewById<Button>(R.id.btnStart)
        val infoButton = findViewById<ImageButton>(R.id.imgBtn1)

        // Sending user to countdown activity
        startButton.setOnClickListener {
            val intent = Intent(this, CountdownActivity::class.java)
            startActivity(intent)
        }

        //  Handle Information about the application
        infoButton.setOnClickListener {
            Toast.makeText(
                this,
                "History Flash: Test your African history knowledge with quick true/false questions!",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
