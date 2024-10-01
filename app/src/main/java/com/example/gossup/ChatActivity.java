package com.example.gossup;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gossup.model.UserModel;
import com.example.gossup.utils.AndroidUtil;

public class ChatActivity extends AppCompatActivity {

    UserModel otherUser;

    TextView otherUsername;
    EditText chatMessageInput;
    ImageButton sendMessage;
    ImageButton backBtn;
    RecyclerView recyclerView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_chat);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //get UserModel

        otherUser = AndroidUtil.getUserModelFromIntent(getIntent());
        chatMessageInput = findViewById(R.id.chat_message_input);
        otherUsername = findViewById(R.id.other_username);
        sendMessage = findViewById(R.id.message_send_btn);
        backBtn = findViewById(R.id.back_btn);
        recyclerView = findViewById(R.id.chat_recycler_view);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getOnBackPressedDispatcher().onBackPressed();
            }
        });

        otherUsername.setText(otherUser.getUsername());


    }
}