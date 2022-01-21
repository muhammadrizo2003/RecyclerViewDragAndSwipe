package com.example.project14k.helper

// this interface is for drag and drop and swipe with remove
interface ItemTouchHelperAdapter {
    fun onItemMove(from: Int, to: Int)
    fun onItemDismiss(position: Int)
}

