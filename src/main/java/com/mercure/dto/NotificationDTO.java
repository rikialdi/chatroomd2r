package com.mercure.dto;

import com.mercure.utils.MessageTypeEnum;

/**
 * POJO class used to send Notification to Client
 */
public class NotificationDTO {

    private Long  fromUserId;

    private String senderName;

    private MessageTypeEnum type;

    private String message;

    private String lastMessageDate;

    private String groupUrl;

    private Long  groupId;

    private String fileUrl;

    private String fileName;

    private boolean isMessageSeen;

    public Long  getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long  fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public MessageTypeEnum getType() {
        return type;
    }

    public void setType(MessageTypeEnum type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLastMessageDate() {
        return lastMessageDate;
    }

    public void setLastMessageDate(String lastMessageDate) {
        this.lastMessageDate = lastMessageDate;
    }

    public String getGroupUrl() {
        return groupUrl;
    }

    public void setGroupUrl(String groupUrl) {
        this.groupUrl = groupUrl;
    }

    public Long  getGroupId() {
        return groupId;
    }

    public void setGroupId(Long  groupId) {
        this.groupId = groupId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isMessageSeen() {
        return isMessageSeen;
    }

    public void setMessageSeen(boolean messageSeen) {
        isMessageSeen = messageSeen;
    }
}
