package me.Blen;

import java.util.ArrayList;

public class Role {
    private long id;
    private String name;
    private ArrayList<User> usersListForRole;

    public Role() {
        usersListForRole = new ArrayList<>();
    }

    public ArrayList<User> getUsersListForRole() {
        return usersListForRole;
    }

    public void setUsersListForRole(ArrayList<User> usersListForRole) {
        this.usersListForRole = usersListForRole;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
