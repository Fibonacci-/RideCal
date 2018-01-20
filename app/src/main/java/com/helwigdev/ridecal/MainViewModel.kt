package com.helwigdev.ridecal

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.helwigdev.ridecal.uimodels.Event

/**
 * Created by tyler on 1/19/18.
 */
class MainViewModel(application: Application) : AndroidViewModel(application){
    var eventModel: EventModel = EventModel()

    val text = ObservableField<String>("initialized data")

    val isLoading = ObservableField<Boolean>(false)

    var events = MutableLiveData<ArrayList<Event>>()

    fun loadEvents(){
        isLoading.set(true)
        eventModel.getEvents(object : OnEventsReadyCallback{
            override fun onEventsReady(data: ArrayList<Event>) {
                events.value = data
                isLoading.set(false)
            }
        })
    }


}