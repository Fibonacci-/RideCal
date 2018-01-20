package com.helwigdev.ridecal

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.helwigdev.ridecal.databinding.ActivityMainBinding
import com.helwigdev.ridecal.databinding.EventItemBinding
import com.helwigdev.ridecal.uimodels.Event
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), EventRecyclerViewAdapter.OnItemClickListener {


    lateinit var binding: ActivityMainBinding

    private val eventRepositoryViewRecycler = EventRecyclerViewAdapter(arrayListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.eventRv.layoutManager = LinearLayoutManager(this)
        binding.eventRv.adapter = eventRepositoryViewRecycler

        viewModel.events.observe(this,
                Observer<ArrayList<Event>> {
                    it?.let { eventRepositoryViewRecycler.replaceData(it) }
                })



    }



    override fun onItemClick(position: Int) {
        Toast.makeText(this,"You clicked item $position!", Toast.LENGTH_SHORT).show()
    }
}
