package com.mercure.dto;

public class AuthUserDTO {

    private Long  id;

    private String username;

    private String firstGroupUrl;

    private String wsToken;

    public AuthUserDTO(Long  id, String username, String firstGroupUrl, String wsToken) {
        this.id = id;
        this.username = username;
        this.firstGroupUrl = firstGroupUrl;
        this.wsToken = wsToken;
    }

    public Long  getId() {
        return id;
    }

    public void setId(Long  id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstGroupUrl() {
        return firstGroupUrl;
    }

    public void setFirstGroupUrl(String firstGroupUrl) {
        this.firstGroupUrl = firstGroupUrl;
    }

    public String getWsToken() {
        return wsToken;
    }

    public void setWsToken(String wsToken) {
        this.wsToken = wsToken;
    }
}
