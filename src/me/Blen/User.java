package me.Blen;

import java.util.ArrayList;

public class User {
    private long id;
    private String userName;
    private String password;
    private ArrayList<Role> rolesListForUser;

    public ArrayList<Role> getRolesListForUser() {
        return rolesListForUser;
    }

    public void setRolesListForUser(ArrayList<Role> rolesListForUser) {
        this.rolesListForUser = rolesListForUser;
    }

    public User() {
        rolesListForUser = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
