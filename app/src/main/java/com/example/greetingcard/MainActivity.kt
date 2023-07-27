package com.example.greetingcard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.greetingcard.lifecycles.SecondActivity
import com.example.greetingcard.recyclerview.RecyclerViewActivity

/***
 * Intent is used to invoke another activity from this activity.
 * first onResume is called on first activity and second activity got created by calling onCreate onStart onResume
 * and after these three calls onStop is called on first activity.
 * onPause onStop onDestroy is called when we closed the application.
 */
class MainActivity : AppCompatActivity() {

    lateinit var textView : TextView
    lateinit var changeButton: Button
    lateinit var resetButton : Button
    lateinit var secondActivityButton : Button
    lateinit var recyclerActivityButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView=findViewById(R.id.text)
        changeButton=findViewById(R.id.changeButton)
        resetButton=findViewById(R.id.resetButton)
        secondActivityButton=findViewById(R.id.goToSecondButton)
        recyclerActivityButton=findViewById(R.id.recyclerViewButton)

        changeButton.setOnClickListener {
            textView.text="Let's learn together!"
            Toast.makeText(this,"Test is changed",Toast.LENGTH_LONG).show()
        }

        resetButton.setOnClickListener {
            textView.text="Have a good day!"
            Toast.makeText(this,"Reset done",Toast.LENGTH_LONG).show()
        }

        secondActivityButton.setOnClickListener {
            var intent : Intent = Intent(this@MainActivity, SecondActivity::class.java)
            startActivity(intent)
            Toast.makeText(this,"Second Activity is opened",Toast.LENGTH_LONG).show()
        }

        recyclerActivityButton.setOnClickListener {
            var intent = Intent(this@MainActivity,RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        Log.d("checktag","Main Activity onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("checktag","Main Activity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("checktag","Main Activity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("checktag","Main Activity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("checktag","Main Activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("checktag","Main Activity onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("checktag","Main Activity onRestart")
    }
}