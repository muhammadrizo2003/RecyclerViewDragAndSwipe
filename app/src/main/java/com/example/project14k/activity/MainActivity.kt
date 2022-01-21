package com.example.project14k.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.project14k.R
import com.example.project14k.adapter.CustomAdapter
import com.example.project14k.helper.SimpleItemTouchHelperCallBack
import com.example.project14k.model.Member
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        refreshAdapter(prepareMemberList())
    }

    private fun initViews() {
        context = this
        recyclerView = recycler_view
    }

    private fun refreshAdapter(members: ArrayList<Member>) {
        val customAdapter = CustomAdapter(context, members)
        recyclerView.adapter = customAdapter

        val callback: ItemTouchHelper.Callback = SimpleItemTouchHelperCallBack(customAdapter)
        val itemTouchHelper = ItemTouchHelper(callback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun prepareMemberList(): ArrayList<Member> {

        val members: ArrayList<Member> = ArrayList<Member>()

        for (i in 1..40) members.add(Member("Muhammadrizo$i", "Nurullaxo'jayev$i"))

        return members
    }
}




