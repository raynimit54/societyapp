package com.example.society.ui.events

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.society.R

class EventsFragment : Fragment() {

    private lateinit var eventsViewModel: EventsViewModel
    private lateinit var eventsAdapter: EventsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        eventsViewModel = ViewModelProvider(this).get(EventsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_events, container, false)

        val recyclerView: RecyclerView = root.findViewById(R.id.events_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(context)
        eventsAdapter = EventsAdapter()
        recyclerView.adapter = eventsAdapter

        eventsViewModel.events.observe(viewLifecycleOwner) { events ->
            eventsAdapter.submitList(events)
        }

        return root
    }
}
