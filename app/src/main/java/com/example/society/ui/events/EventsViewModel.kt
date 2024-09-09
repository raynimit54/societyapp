package com.example.society.ui.events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EventsViewModel : ViewModel() {
        private val _events = MutableLiveData<List<Event>>().apply {
                value = listOf(
                Event("Community Meetup", "2024-09-15", "Central Park"),
                Event("Ganpati Celebration", "2024-09-20", "Community Center"),
                Event("Movie Night", "2024-09-25", "Open Air Theater")
                )
        }
        val events: LiveData<List<Event>> = _events
}
data class Event(val title: String, val date: String, val location: String)


