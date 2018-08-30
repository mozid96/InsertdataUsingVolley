package com.example.user.insertdatausingvolley;

/**
 * Created by USER on 8/30/2018.
 */

public class Model {
    String id,name,location,mobile,username,password,type;

    public Model(String id, String name, String location, String mobile, String username, String password, String type) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public Model(String name, String location, String mobile, String username, String password, String type) {
        this.name = name;
        this.location = location;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getMobile() {
        return mobile;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }
}
