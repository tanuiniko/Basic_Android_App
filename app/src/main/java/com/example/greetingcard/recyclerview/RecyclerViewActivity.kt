package com.example.greetingcard.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.greetingcard.R

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var nameList : ArrayList<String>
    lateinit var numberList : ArrayList<String>
    lateinit var adapter : PhoneAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_view_activity)

        recyclerView=findViewById(R.id.recyclerView)

        recyclerView.layoutManager=LinearLayoutManager(this@RecyclerViewActivity)
//        recyclerView.layoutManager=GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
//        recyclerView.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        var nameArray= listOf("Lilly","Atlas","Rile","Alysa","Josh","Corrigan","Bloom","Blossom")
        nameList= java.util.ArrayList(nameArray)
        var numberArray= listOf("9999998888","9898989898","9989798989","9797979898","9898980989","9798979890","9595969798","9798969696")
        numberList=java.util.ArrayList(numberArray)

        adapter = PhoneAdapter(nameList,numberList,this@RecyclerViewActivity)
        recyclerView.adapter=adapter
    }
}