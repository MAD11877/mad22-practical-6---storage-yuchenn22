package com.example.practicals;

public class User {
    String name;
    String description;
    int id;
    boolean followed;


    public User(String Name, String Desc, int Id, boolean Followed) {
        name = Name;
        description = Desc;
        id = Id;
        followed = Followed;
    }
}