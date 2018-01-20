package com.helwigdev.ridecal

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.helwigdev.ridecal.databinding.EventItemBinding
import com.helwigdev.ridecal.uimodels.Event

/**
 * Created by tyler on 1/19/18.
 */
class EventRecyclerViewAdapter(private var items: ArrayList<Event>,
                               private var listener: OnItemClickListener):
        RecyclerView.Adapter<EventRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = EventItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(items[position], listener)

    override fun getItemCount(): Int = items.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun replaceData(arrayList: ArrayList<Event>){
        items = arrayList
        notifyDataSetChanged()
    }

    class ViewHolder(private var binding: EventItemBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event, listener: OnItemClickListener?) {
            binding.event = event
            if (listener != null) {
                binding.root.setOnClickListener({ _ -> listener.onItemClick(layoutPosition) })
            }

            binding.executePendingBindings()
        }
    }


}