package com.example.greetingcard.todolist

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.greetingcard.databinding.ActivityToDoBinding

class ToDoActivity : AppCompatActivity() {

    lateinit var binding : ActivityToDoBinding
    var itemList = ArrayList<String>()
    var fileHelper = FileHelper()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityToDoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title ="TODO LIST"

        itemList=fileHelper.readData(this)

        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,itemList)
        binding.listViewTodo.adapter=adapter

        binding.addToDo.setOnClickListener {
            var item : String = binding.textToDo.text.toString()
            if(item=="") Toast.makeText(applicationContext,"Please add a TODO and then click ADD",Toast.LENGTH_LONG).show()
            else{
                itemList.add(item)
                binding.textToDo.setText("")
                fileHelper.writeData(itemList, this)
                adapter.notifyDataSetChanged()
            }
        }

        binding.listViewTodo.setOnItemClickListener { parent, view, position, id ->
            var alert = AlertDialog.Builder(this)
                .setTitle("Delete")
                .setMessage("Do you want to delete this item from the list?")
                .setCancelable(false)
                .setNegativeButton("No") { dialog, which ->
                    dialog.cancel()
                }
                .setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, which ->
                    itemList.removeAt(position)
                    adapter.notifyDataSetChanged()
                    fileHelper.writeData(itemList,applicationContext)
                })
            alert.create().show()
        }
    }
}