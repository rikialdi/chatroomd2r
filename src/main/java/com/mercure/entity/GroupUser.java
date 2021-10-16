package com.mercure.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "group_user")
@IdClass(GroupRoleKey.class)
public class GroupUser implements Serializable {

    @Id
    private Long groupId;

    @Id
    private Long userId;

    @ManyToOne
    @MapsId("groupId")
    @JoinColumn(name = "group_id")
    GroupEntity groupMapping;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    UserEntity userMapping;

    private Long role;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public GroupEntity getGroupMapping() {
        return groupMapping;
    }

    public void setGroupMapping(GroupEntity groupMapping) {
        this.groupMapping = groupMapping;
    }

    public UserEntity getUserMapping() {
        return userMapping;
    }

    public void setUserMapping(UserEntity userMapping) {
        this.userMapping = userMapping;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, userId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        GroupUser groupRoleKey = (GroupUser) obj;
        return groupId == groupRoleKey.groupId &&
                userId == groupRoleKey.userId;
    }
}
