package com.example.gossup.model;

import java.security.Timestamp;
import java.util.List;

public class ChatroomModel {

    String chatroomId;
    List<String> userIds;
    Timestamp lastMessageTimeStamp;
    String laseMessageSenderId;

    public ChatroomModel() {
    }

    public ChatroomModel(String chatroomId, List<String> userIds, Timestamp lastMessageTimeStamp, String laseMessageSenderId) {
        this.chatroomId = chatroomId;
        this.userIds = userIds;
        this.lastMessageTimeStamp = lastMessageTimeStamp;
        this.laseMessageSenderId = laseMessageSenderId;
    }

    public ChatroomModel(String chatroomId, List<String> list, com.google.firebase.Timestamp now, String laseMessageSenderId) {
    }

    public String getChatroomId() {
        return chatroomId;
    }

    public void setChatroomId(String chatroomId) {
        this.chatroomId = chatroomId;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public Timestamp getLastMessageTimeStamp() {
        return lastMessageTimeStamp;
    }

    public void setLastMessageTimeStamp(Timestamp lastMessageTimeStamp) {
        this.lastMessageTimeStamp = lastMessageTimeStamp;
    }

    public String getLaseMessageSenderId() {
        return laseMessageSenderId;
    }

    public void setLaseMessageSenderId(String laseMessageSenderId) {
        this.laseMessageSenderId = laseMessageSenderId;
    }
}
