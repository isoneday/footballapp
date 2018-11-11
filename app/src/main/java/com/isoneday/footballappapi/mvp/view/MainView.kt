package com.isoneday.footballappapi.mvp.view

import com.isoneday.footballappapi.mvp.model.EventsItem

interface MainView {
    fun showloading()
    fun hideloading()
    fun showmessage(message :String?)
    fun showlistteam(listteam : List<EventsItem>?)

}