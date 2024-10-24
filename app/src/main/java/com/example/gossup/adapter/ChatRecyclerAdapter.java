package com.example.gossup.adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gossup.ChatActivity;
import com.example.gossup.R;
import com.example.gossup.SearchUserActivity;
import com.example.gossup.model.ChatMessageModel;
import com.example.gossup.utils.AndroidUtil;
import com.example.gossup.utils.FirebaseUtil;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ChatRecyclerAdapter extends FirestoreRecyclerAdapter<ChatMessageModel, ChatRecyclerAdapter.ChatModelViewHolder> {

    Context context;


    public ChatRecyclerAdapter(@NonNull FirestoreRecyclerOptions<ChatMessageModel> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ChatModelViewHolder chatModelViewHolder, int i, @NonNull ChatMessageModel chatMessageModel) {
        if (chatMessageModel.getSenderId().equals(FirebaseUtil.currentUserId())){
            chatModelViewHolder.leftChatLayout.setVisibility(View.GONE);
            chatModelViewHolder.rightChatTextview.setVisibility(View.VISIBLE);
            chatModelViewHolder.rightChatTextview.setText(chatMessageModel.getMessage());
        }else{
            chatModelViewHolder.rightChatLayout.setVisibility(View.GONE);
            chatModelViewHolder.leftChatTextview.setVisibility(View.VISIBLE);
            chatModelViewHolder.leftChatTextview.setText(chatMessageModel.getMessage());
        }

    }

    @NonNull
    @Override
    public ChatModelViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.chat_message_recycler_row, viewGroup, false);
        return new ChatModelViewHolder(view);
    }

    class ChatModelViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftChatLayout, rightChatLayout;
        TextView leftChatTextview, rightChatTextview;



        public ChatModelViewHolder(@NonNull View itemView) {
            super(itemView);

            leftChatLayout = itemView.findViewById(R.id.left_chat_layout);
            rightChatLayout = itemView.findViewById(R.id.right_chat_layout);
            leftChatTextview = itemView.findViewById(R.id.left_chat_textview);
            rightChatTextview = itemView.findViewById(R.id.right_chat_textview);




        }
    }

}

