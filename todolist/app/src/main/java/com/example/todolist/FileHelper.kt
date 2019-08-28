package com.example.todolist

import android.content.Context
import java.io.*

class FileHelper{
    val FILENAME:String="listinfo.dat"
    fun writeData(item : ArrayList<String>, context:Context){
        try{
            var fos : FileOutputStream = context.openFileOutput(FILENAME, Context.MODE_PRIVATE)
            var oos : ObjectOutputStream = ObjectOutputStream(fos)
            oos.writeObject(item)
            oos.close()
        }catch(e : FileNotFoundException){
            e.printStackTrace()
        }catch (e : IOException){
            e.printStackTrace()
        }
    }
    fun readData  (context : Context):ArrayList<String>?{
        var itemlist : ArrayList<String>? = null
        try{
            var fis : FileInputStream= context.openFileInput(FILENAME)
            var ois : ObjectInputStream = ObjectInputStream(fis)
            itemlist = ois.readObject() as ArrayList<String>?
        }catch(e : FileNotFoundException){
            e.printStackTrace()
        }catch(e: IOException){
            e.printStackTrace()
        }
        return itemlist
    }
}