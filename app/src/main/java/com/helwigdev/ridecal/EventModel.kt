package com.helwigdev.ridecal

import android.os.Handler
import android.util.Log
import com.helwigdev.ridecal.uimodels.Event
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by tyler on 1/19/18.
 */
class EventModel {

    fun getEvents(onEventsReadyCallback: OnEventsReadyCallback){
        var date1 = Date(2018,1,19,8,0)
        var date2 = Date(2018,1,20,10,5, 30)
        var date3 = Date(2018,1,21,10,5, 30)
        var date4 = Date(2018,1,21,11,30, 0)

        var event1 = Event("Event Number 1","Spencer's Equestrian", date1, date2)
        var event2 = Event("Event Number 2","Devon Horse Show",date3,date4)
        var event3 = Event("Love","Jenna's Heart",date4,Date(2018, 1, 21, 13, 0, 0))

        var arrayList: ArrayList<Event> = ArrayList()

        arrayList.add(event1)
        arrayList.add(event2)
        arrayList.add(event3)

        Log.d("EventModel","getEvents triggered!")

        Handler().postDelayed({ onEventsReadyCallback.onEventsReady(arrayList)}, 2000)

    }
}

interface OnDataReadyCallback{
    fun onDataReady(data : String)
}

interface OnEventsReadyCallback{
    fun onEventsReady(data : ArrayList<Event>)
}