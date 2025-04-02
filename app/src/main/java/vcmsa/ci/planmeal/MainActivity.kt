package vcmsa.ci.planmeal
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private lateinit var btnClear: Button
    private lateinit var btnExit: Button
    private lateinit var checkBtn: Button
    private lateinit var userResult: TextView
    private lateinit var greetingTxt: TextView
    private lateinit var inputUser: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        btnClear = findViewById(R.id.btnClear)
        userResult = findViewById(R.id.userInput)
        btnExit = findViewById(R.id.btnExit)
        checkBtn = findViewById(R.id.checkBtn)
        greetingTxt = findViewById(R.id.greetingTxt)
        inputUser = findViewById(R.id.inputUser)



        btnClear.setOnClickListener {
            inputUser.text.clear()
            userResult.text = ""
        }


            btnExit.setOnClickListener {
            //moveTaskToBack(true)
            //android.os.Process.killProcess(android.os.Process.myPid())
            //exitProcess(1)
            finishAffinity()
            exitProcess(1)

        }




        checkBtn.setOnClickListener {
            checkMeal()

        }

    }


    private fun isNotEmpty(): Boolean {
        var b = true
        if (inputUser.text.toString().trim().isEmpty()) {
            inputUser.error = "Oops!Input Required!"

            b = false
        }
        return b
    }

    private fun checkMeal() {

        if (isNotEmpty()) {

            val time = inputUser.text.toString().trim().toInt()

            when (time) {

                in 800..1100 -> userResult.text = "Breakfast - Oats or Porridge"
                in 1101..1200 -> userResult.text = "Mid-Morning - Eggs or Pancakes"
                in 1201.. 1600-> userResult.text = "Lunch - Pizza or Waffles and Ice Cream"
                in 1601..1700 -> userResult.text = "Snack - Peanuts or Oranges"
                in 1701..1900 -> userResult.text = "Dinner - Sir lion,chips and mushroom sauce or Beef Burger"


                else -> {
                    userResult.text = "Invalid Time! Please enter time between 800 to 1900."
                }
            }
        }
    }

}
//The independent Institute of Education ,2025. Introduction to Mobile Application Development IMAD5112/p/w Module Manual. The Independent Institute of Education: Unpublished. //
//The Independent Institute of Education, 2025. Introduction to Mobile Application Development [IMAD5112]. nt. [online via internal VLE] The Independent Institute of Education.[Source Code] Available at: <Lecture Slides - IMAD5112: APP Gen Revised XML Main > [Accessed Date 02 February 2025]. <https://mystudies.iie.edu.za/d2l/le/lessons/22118/topics/2205037>//
