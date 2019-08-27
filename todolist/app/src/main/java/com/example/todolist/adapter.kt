package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class todoAdapter(todoList:MutableList<MainActivity.todoThing>): RecyclerView.Adapter<todoAdapter.ViewHolder>(){
    private var todoList : MutableList<MainActivity.todoThing> = todoList
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var todo = view.findViewById<View>(R.id.todolist) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): todoAdapter.ViewHolder {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.recyclerview_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var todoThing = todoList!![position]
        holder!!.todo.text = todoThing.thing
    }

    override fun getItemCount(): Int {
        return todoList!!.size
    }
}
