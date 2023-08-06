package com.example.greetingcard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.greetingcard.R

class BlankFragment : Fragment() {

    lateinit var button : Button
    lateinit var editText : TextView
    lateinit var fragmentView : View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentView = inflater.inflate(R.layout.fragment_blank, container, false)

        button=fragmentView.findViewById(R.id.buttonFrag1)
        editText=fragmentView.findViewById(R.id.editTextFragment1)

        button.setOnClickListener {
            var data = Bundle()
            data.putString("message", editText.text.toString())
            parentFragmentManager.setFragmentResult("DataFrom1", data)
            editText.text = ""
        }

        parentFragmentManager.setFragmentResultListener("DataFrom2",this
        ) { requestKey, result ->
            editText.text=result.getString("message2")
        }

        return fragmentView
    }
}