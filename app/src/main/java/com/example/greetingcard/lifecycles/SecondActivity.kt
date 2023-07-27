package com.example.greetingcard.lifecycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.greetingcard.R

/***
 * The second activity got destroyed when the first activity got restarted.
 * onStop was called on first activity when second activity got created.
 */
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("checktag","Second ACtivity onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("checktag","Second ACtivity onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("checktag","Second ACtivity onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("checktag","Second Activity onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("checktag","Second Activity onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("checktag","Second Activity onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("checktag","Second Activity onRestart")
    }

}