package com.example.society.ui.chat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatViewModel : ViewModel() {

    private val _messages = MutableLiveData<List<ChatMessage>>().apply {
        value = listOf(
            ChatMessage("Hello, everyone!", "Anamika", "09:00 AM"),
            ChatMessage("Hi Anamika! How are you?", "Vishnu", "09:05 AM")
        )
    }
    val messages: LiveData<List<ChatMessage>> = _messages

    fun sendMessage(message: String) {
        val newMessage = ChatMessage(message, "You", "Now")
        val currentList = _messages.value?.toMutableList() ?: mutableListOf()
        currentList.add(newMessage)
        _messages.value = currentList
    }
}

data class ChatMessage(val content: String, val sender: String, val time: String)
