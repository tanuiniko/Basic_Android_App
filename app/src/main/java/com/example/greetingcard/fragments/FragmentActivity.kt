package com.example.greetingcard.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.greetingcard.R
import com.example.greetingcard.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {

    lateinit var binding : ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fragment1Button.setOnClickListener {
            replaceFragment(BlankFragment())
        }

        binding.fragment2Button.setOnClickListener {
            replaceFragment(BlankFragment2())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_view,fragment)
        Log.d("ttttt",(R.id.fragment_container_view.toString()==binding.fragmentContainerView.id.toString()).toString())
        fragmentTransaction.commit()
    }
}