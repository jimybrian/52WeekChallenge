package com.outreach.fiftytwoweekchallenge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.outreach.fiftytwoweekchallenge.databinding.ItemWeekBinding

//Holds the list items for the weeks
class WeekAdapter : RecyclerView.Adapter<WeekViewHolder>() {

    var listWeeks: List<WeekItem> = ArrayList()

    //create an instance of viewholder layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekViewHolder {
        val binding : ItemWeekBinding = DataBindingUtil.inflate(LayoutInflater.from(
            parent.context
        ), R.layout.item_week, parent, false)

        return WeekViewHolder(binding)
    }

    //Bind data to the view holder
    override fun onBindViewHolder(holder: WeekViewHolder, position: Int) {
        val week = listWeeks[position]
        holder.bindItem(week)
    }

    //Set the number of items in the recycler view
    override fun getItemCount(): Int {
        return listWeeks.size
    }

    //Update the list items
    fun updateItems(items: List<WeekItem>){
        listWeeks = items
        notifyDataSetChanged()
    }

}

//Holds the layout for a week item
class WeekViewHolder(val binding: ItemWeekBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: WeekItem){
        binding.weekItem = item
        binding.executePendingBindings()
    }

}