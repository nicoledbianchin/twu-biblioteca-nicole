package com.twu.biblioteca.models;

public interface LibraryProduct {
    String getName();
    String getAuthorOrDirector();
    int getPublishedYear();
    int getRate();
    void setUserName(String username);
    String getUserName();
}
