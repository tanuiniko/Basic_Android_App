package com.example.greetingcard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.greetingcard.R

class BlankFragment2 : Fragment() {

    lateinit var fragmentView : View
    lateinit var editText : TextView
    lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView=inflater.inflate(R.layout.fragment_blank2, container, false)

        editText=fragmentView.findViewById(R.id.editTextFrag2)
        button=fragmentView.findViewById(R.id.buttonFrag2)

        parentFragmentManager.setFragmentResultListener("DataFrom1",this
        ) { requestKey, result ->
            var data = result.getString("message")
            editText.text = data
        }

        button.setOnClickListener {
            var data = Bundle()
            data.putString("message2",editText.text.toString())
            parentFragmentManager.setFragmentResult("DataFrom2",data)
            editText.text=""
        }
        return fragmentView
    }
}