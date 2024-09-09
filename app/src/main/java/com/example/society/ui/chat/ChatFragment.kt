package com.example.society.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.society.R

class ChatFragment : Fragment() {
        private lateinit var chatViewModel: ChatViewModel
        private lateinit var chatAdapter: ChatAdapter

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

                chatViewModel = ViewModelProvider(this).get(ChatViewModel::class.java)
                val root = inflater.inflate(R.layout.fragment_chat, container, false)

                val recyclerView: RecyclerView = root.findViewById(R.id.chat_recycler_view)
                recyclerView.layoutManager = LinearLayoutManager(context)
                chatAdapter = ChatAdapter()
                recyclerView.adapter = chatAdapter

                chatViewModel.messages.observe(viewLifecycleOwner) { messages ->
                        chatAdapter.submitList(messages)
                        recyclerView.scrollToPosition(messages.size - 1)
                }

                val messageInput: EditText = root.findViewById(R.id.message_input)
                val sendButton: Button = root.findViewById(R.id.send_button)

                sendButton.setOnClickListener {
                val message = messageInput.text.toString().trim()
                if (message.isNotEmpty()) {
                chatViewModel.sendMessage(message)
                messageInput.text.clear()
                }
        }
        return root
        }
}
