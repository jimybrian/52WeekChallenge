package com.outreach.fiftytwoweekchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.outreach.fiftytwoweekchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    val viewModel: WeekViewModel = WeekViewModel()

    val adapter: WeekAdapter = WeekAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Set the life cycle owner and the viewmodel this view
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        //Set the adapter to the recycler view
        binding.rcWeeks.adapter = adapter
        //Set the layout manager to the recycler view
        binding.rcWeeks.layoutManager = LinearLayoutManager(this)

        //Observe the amount to get when the amount is update
        viewModel.amount.observe(this, Observer {
                amount ->
            if(amount.isNotEmpty()) {
                if(viewModel.amountValidation(amount)) {
                    val weeks = viewModel.updateWeeks(amount)
                    adapter.updateItems(weeks)
                }else
                    Toast.makeText(this, "Enter a value between 1 and 100000", Toast.LENGTH_SHORT).show()
            }
        })

    }
}