package com.example.practicals;

import java.util.ArrayList;

public class User {
    String name;
    String description;
    int id;
    boolean followed;
    static ArrayList<User> userList = new ArrayList<>();


    public User(String Name, String Desc, int Id, boolean Followed) {
        name = Name;
        description = Desc;
        id = Id;
        followed = Followed;
    }
}