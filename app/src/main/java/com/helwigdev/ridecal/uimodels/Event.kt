package com.helwigdev.ridecal.uimodels

import java.util.*

/**
 * Created by tyler on 1/19/18.
 */
class Event(var eventName: String?, var eventLocation: String?, var eventStartDate: Date = Date(), var eventEndDate: Date = Date()){

    var eventStartDateString = eventStartDate.toString()
    var eventDuration: Long = eventEndDate.time - eventStartDate.time

    var eventDurationFormatted = millToTimeDuration(eventDuration)

    fun millToTimeDuration(mills: Long): String {
        var rString = ""
        var seconds = mills / 1000
        var minutes: Long = 0
        var hours: Long = 0
        var days: Long = 0
        if(seconds > 60){
            minutes = seconds / 60
            seconds %= 60
        }
        if(minutes > 60){
            hours = minutes / 60
            minutes %= 60
        }
        if(hours > 24){
            days = hours / 24
            hours %= 24
        }


        return when {
            days > 0 -> "$days d $hours h $minutes m $seconds s"
            hours > 0 -> "$hours h $minutes m $seconds s"
            minutes > 0 -> "$minutes m $seconds s"
            else -> "$seconds s"
        }
    }


}