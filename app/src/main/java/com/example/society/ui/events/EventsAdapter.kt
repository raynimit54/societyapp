package com.example.society.ui.events

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.society.R

class EventsAdapter : ListAdapter<Event, EventsAdapter.EventViewHolder>(EventDiffCallback()) {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context)
        .inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
        }

        override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = getItem(position)
        holder.bind(event)
        }

        class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val titleTextView: TextView = itemView.findViewById(R.id.event_title)
            private val dateTextView: TextView = itemView.findViewById(R.id.event_date)
            private val locationTextView: TextView = itemView.findViewById(R.id.event_location)

            fun bind(event: Event) {
                titleTextView.text = event.title
                dateTextView.text = event.date
                locationTextView.text = event.location
                }
        }
}

class EventDiffCallback : DiffUtil.ItemCallback<Event>() {
    override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem == newItem
    }
}