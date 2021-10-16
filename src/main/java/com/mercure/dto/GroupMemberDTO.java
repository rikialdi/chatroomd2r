package com.mercure.dto;

public class GroupMemberDTO {

    private Long  userId;

    private String firstName;

    private String lastName;

    private boolean isAdmin;

    public Long  getUserId() {
        return userId;
    }

    public void setUserId(Long  userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public GroupMemberDTO() {
    }

    public GroupMemberDTO(Long  userId, String firstName, String lastName, boolean isAdmin) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isAdmin = isAdmin;
    }
}
