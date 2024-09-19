package org.example.Controller;

import org.example.Model.User;
import org.example.Service.UserService;

import java.util.Scanner;

public class UserController {
    UserService userService = new UserService();
    Scanner sc = new Scanner(System.in);

    public void saveUser() {
        User user = new User();
        userService.insertUser(user);
    }

    public void getAllUser() {
        userService.displyAllUser();
    }

    public void deletedb() {
        System.out.println("Enter User Id to delete:");
        int id = sc.nextInt();
        userService.deleteUser(id);

    }

    public void updatedb() {
        System.out.println("Enter User Id to update:");
        int id = sc.nextInt();

        userService.updateUser(id);

    }
}
