package com.example.todolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    class todoThing(thing:String) {
        var thing: String = thing
    }
    fun initRecyclerTodoList(list : MutableList<todoThing> ){
        var todoListAdapter = todoAdapter(list)
        recycleTodo.adapter = todoListAdapter
        recycleTodo.layoutManager = LinearLayoutManager(applicationContext)

    }
    var todoList:MutableList<todoThing> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        submitBtn.setOnClickListener{
            val tempT = submitText.text.toString()
            val tempThing = todoThing(tempT)
            todoList.add(tempThing)
            initRecyclerTodoList(todoList)
        }
    }
}
