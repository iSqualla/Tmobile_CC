package com.example.tmobile.ui.controller

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmobile.data.SearchResponseItem
import com.example.tmobile.databinding.SearchItemBinding

class SearchAdapter(private val list: ArrayList<SearchResponseItem>) :
    RecyclerView.Adapter<SearchAdapter.MainViewHolder>() {
    class MainViewHolder(var itemBinding: SearchItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            SearchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.itemBinding.searchItem = list[position]
    }

    override fun getItemCount(): Int = list.size

    fun addData(newList: List<SearchResponseItem>) {
        list.clear()
        list.addAll(newList)
    }
}