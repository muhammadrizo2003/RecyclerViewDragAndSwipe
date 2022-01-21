package com.example.project14k.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project14k.R
import com.example.project14k.helper.ItemTouchHelperAdapter
import com.example.project14k.model.Member
import kotlinx.android.synthetic.main.item_member.view.*
import java.util.*

// this is a simple recycler view adapter
// recycler view drag and swipe
class CustomAdapter(private var context: Context, private var itemList: ArrayList<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>(), ItemTouchHelperAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_member, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val member: Member = itemList[position]

        // set data to item
        if (holder is CustomViewHolder) {
            val txt_name = holder.itemView.findViewById<TextView>(R.id.txt_name)
            val txt_surname = holder.itemView.findViewById<TextView>(R.id.txt_surname)

            txt_name.text = member.name
            txt_surname.text = member.surname
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    private class CustomViewHolder(
        val view: View,
        var txt_name: TextView = view.txt_name,
        var txt_surname: TextView = view.txt_surname
    ) : RecyclerView.ViewHolder(view) {

            //        init {
            //            txt_name = view.findViewById(R.id.txt_name)
            //            txt_surname = view.findViewById(R.id.txt_surname)
            //        }
    }

    override fun onItemDismiss(position: Int) {
        itemList.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onItemMove(from: Int, to: Int) {
        if (from < to) {
            for (i in from until to) {
                Collections.swap(itemList, i, i + 1)
            }
        } else {
            for (i in from downTo to + 1) {
                Collections.swap(itemList, i, i - 1)
            }
        }
        notifyItemMoved(from, to)
    }
}
