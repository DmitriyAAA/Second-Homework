package bonch.dev.school

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_first.*
import java.lang.reflect.Field

class FirstActivity : AppCompatActivity() {


    private lateinit var indicatorButton: Button
    private lateinit var counterButton: Button
    private lateinit var nextActivityButton: Button
    private lateinit var textField: EditText
    private lateinit var numbers: TextView

    var counter: Int = 0
    var buttonIsTapped: Boolean = false





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        initializeViews()
        setListener()
    }
    private fun initializeViews(){
        indicatorButton=findViewById<Button>(R.id.indicator_button)
        counterButton=findViewById<Button>(R.id.counter_button)
        nextActivityButton=findViewById<Button>(R.id.next_activity_button)
        textField=findViewById<EditText>(R.id.text_field)
        numbers = findViewById(R.id.numbers)

    }
    private fun setListener(){


        indicatorButton.setOnClickListener{
            indicatorButton.isEnabled = false
            buttonIsTapped = true
       }

        counterButton.setOnClickListener{
            counter++
            numbers.text = counter.toString()
        }
        nextActivityButton.setOnClickListener{
            val intent = Intent(this,SecondActivity::class.java)
            intent.putExtra("counter", counter)
            intent.putExtra("buttonIsTapped", buttonIsTapped)
            intent.putExtra("textField", textField.text.toString())
            startActivity(intent)
        }
    }
}
