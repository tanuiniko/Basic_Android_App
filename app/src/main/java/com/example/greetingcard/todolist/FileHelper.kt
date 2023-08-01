package com.example.greetingcard.todolist

import android.content.Context
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class FileHelper {

    var FILE_NAME : String = "todoListInfo.dat"

    fun writeData(item : ArrayList<String>, context : Context){
        var fileOutputStream : FileOutputStream = context.openFileOutput(FILE_NAME,Context.MODE_PRIVATE)
        var objectOutputStream = ObjectOutputStream(fileOutputStream)
        objectOutputStream.writeObject(item)
        objectOutputStream.close()
    }

    fun readData(context: Context) : ArrayList<String>{
        var itemList : ArrayList<String>
        try {
            var fileInputStream : FileInputStream = context.openFileInput(FILE_NAME)
            var objectInputStream = ObjectInputStream(fileInputStream)
            itemList = objectInputStream.readObject() as ArrayList<String>
        } catch (e : FileNotFoundException){
            itemList = ArrayList()
        }
        return itemList
    }
}