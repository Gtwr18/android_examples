package com.example.todolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.list_layout.view.*

class todoListAdapter(context : Context, listBtnClickListener: ListBtnClickListener, items : ArrayList<String>) : BaseAdapter() {

    private var todoListItemList : ArrayList<String> = items
    var listBtnClickListener = listBtnClickListener
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        val context = parent?.context
        if(view ==null){
            val inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater//
            view = inflater.inflate(R.layout.list_layout, parent,false)//
        }
        val todoThing = todoListItemList[position]
        val textview = view!!.findViewById(R.id.textView1) as TextView
        val deleteBtn = view!!.findViewById(R.id.button1) as Button

        textview.text = todoThing
        view.button1.setTag(todoThing)
        view.button1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                if(listBtnClickListener != null){
                    listBtnClickListener.onListBtnClick(v!!.getTag() as String)
                }
            }

        })


        return view
    }

    override fun getItem(position: Int): Any {
        return todoListItemList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return todoListItemList.size
    }
    fun addItem(todoThing : String){
        todoListItemList.add(todoThing)
    }

    interface ListBtnClickListener {
        fun onListBtnClick(selectedPOS: String)
    }
//
//    var rosourceId : Int? = resource
//    private var listBtnClickListner:ListBtnClickListner? = listBtnClickListner



}