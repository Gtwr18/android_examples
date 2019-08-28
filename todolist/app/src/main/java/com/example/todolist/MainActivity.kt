package com.example.todolist

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), todoListAdapter.ListBtnClickListener {
    override fun onListBtnClick(selectedPOS : String) {
        var items = FH.readData(this)
        items!!.remove(selectedPOS)
        adapter = todoListAdapter(this@MainActivity,this@MainActivity,items!!)
        item_list.adapter = adapter
        FH.writeData(items,this@MainActivity)
    }

    var todoList:ArrayList<String> = arrayListOf()
//    var adapter:ArrayAdapter<String>? = null
    var adapter:todoListAdapter? = null
    val FH = FileHelper()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var items = FH.readData(this)
            adapter = todoListAdapter(this,this,items!!)
//            adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items as List<String>)
            item_list.adapter = adapter

        submitBtn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v : View?) {
                var tempText = submitText.text.toString()
                items.add(tempText)
//            adapter!!.add(tempText)
                adapter = todoListAdapter(this@MainActivity,this@MainActivity,items!!)
                item_list.adapter = adapter
                submitText.setText("")
                Toast.makeText(this@MainActivity,"added",Toast.LENGTH_SHORT).show()
                FH.writeData(items,this@MainActivity)
            }
        })
        item_list.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(parent: AdapterView<*>?, v: View?, position: Int, id: Long) {
                val selectedPos = parent?.getItemAtPosition(position) as String
                items.remove(selectedPos)
                (item_list.adapter as BaseAdapter).notifyDataSetChanged()
                FH.writeData(items,this@MainActivity)
            }
        }
    }
}
