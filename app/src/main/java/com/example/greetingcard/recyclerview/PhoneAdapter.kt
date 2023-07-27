package com.example.greetingcard.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.greetingcard.R

class PhoneAdapter(
     var nameList: ArrayList<String>,
     var numberList: ArrayList<String>,
     var context: Context) : RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder>() {

    class PhoneViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        var textViewName : TextView = itemView.findViewById(R.id.nameTextView)
        var textViewNumber : TextView = itemView.findViewById(R.id.phoneNumTextView)
        var cardView : CardView = itemView.findViewById(R.id.cardView)
    }

    /***
     * So as soon as the PhoneViewHolder class is created, this method gets called.
     * We will define the card design that we've made.
     * Thanks to this method we determine which design will be displayed in the recyclerview.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design,parent,false)
        return PhoneViewHolder(view)
    }

    /***
     * This is the method where we specify what should be done when the design we created is connected to the recycler view.
     * In other words, we will show the data on the screen and recycler view in this methods.
     */
    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        holder.textViewName.text= nameList[position]
        holder.textViewNumber.text= numberList[position]

        holder.cardView.setOnClickListener {
            Toast.makeText(context,"${nameList[position]} is selected",Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return nameList.size
    }


}