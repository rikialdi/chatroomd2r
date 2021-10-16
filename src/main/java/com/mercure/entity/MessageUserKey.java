package com.mercure.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MessageUserKey implements Serializable {

    public MessageUserKey() {
    }

    public MessageUserKey(Long messageId, Long userId) {
        this.messageId = messageId;
        this.userId = userId;
    }

    @Column(name = "message_id")
    private Long messageId;

    @Column(name = "user_id")
    private Long userId;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageId, userId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MessageUserKey groupRoleKey = (MessageUserKey) obj;
        return messageId == groupRoleKey.messageId &&
                userId == groupRoleKey.userId;
    }
}
