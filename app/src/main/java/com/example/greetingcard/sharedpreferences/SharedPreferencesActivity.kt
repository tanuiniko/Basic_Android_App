package com.example.greetingcard.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.greetingcard.databinding.ActivitySharedPreferencesBinding

class SharedPreferencesActivity : AppCompatActivity() {

    lateinit var binding: ActivitySharedPreferencesBinding
    lateinit var sharedPreferences : SharedPreferences
    var count : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSp.setOnClickListener {
            count++
            binding.buttonSp.text=""+count
        }
    }

    fun saveData(){
        sharedPreferences=this.getSharedPreferences("save data",Context.MODE_PRIVATE)
        sharedPreferences.edit()
            .putString("nameKey",binding.editTextPersonNameSp.text.toString())
            .putString("messageKey",binding.editTextMultiLineSp.text.toString())
            .putInt("countKey",count)
            .putBoolean("isCheckedKey",binding.checkBoxSp.isChecked)
            .apply()
        Toast.makeText(applicationContext,"your data is saved",Toast.LENGTH_SHORT).show()
    }

    fun retrieveData(){
        sharedPreferences=this.getSharedPreferences("save data",Context.MODE_PRIVATE)
        binding.editTextPersonNameSp.setText(sharedPreferences.getString("nameKey",null))
        binding.editTextMultiLineSp.setText(sharedPreferences.getString("messageKey",null))
        binding.buttonSp.setText(sharedPreferences.getInt("countKey",0).toString())
        binding.checkBoxSp.isChecked=sharedPreferences.getBoolean("isCheckedKey",false)
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    override fun onResume() {
        super.onResume()
        retrieveData()
    }
}