package com.example.society.ui.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EventsViewModel : ViewModel() {
        private val _events = MutableLiveData<List<Event>>().apply {
                value = listOf(
                Event("Community Meetup", "2023-05-15", "Central Park"),
                Event("Charity Fundraiser", "2023-05-20", "Community Center"),
                Event("Movie Night", "2023-05-25", "Open Air Theater")
                )
        }
        val events: LiveData<List<Event>> = _events
}
data class Event(val title: String, val date: String, val location: String)


