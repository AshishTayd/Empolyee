package org.example.Repo;

import org.example.Model.User;

import java.util.ArrayList;

public interface UserInterface {
    void displyAllUser();
    String insertUser(User user);
    void deleteUser(int id );
    void updateUser(int id);

}
