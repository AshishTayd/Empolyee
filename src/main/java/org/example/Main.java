package org.example;

import org.example.Controller.UserController;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserController userController = new UserController();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
           /* System.out.println("1 - Enter user");
            System.out.println("2 - Update user");
            System.out.println("3 - Display all users");
            System.out.println("4 - Delete user");
            System.out.println("5 - Exit");*/

            int data = sc.nextInt();
            switch (data) {
                case 1:
                    userController.saveUser();
                    break;
                case 2:
                    userController.updatedb();
                    break;
                case 3:
                    userController.getAllUser();
                    break;
                case 4:
                    userController.deletedb();
                    break;
                case 5:
                    System.out.println("Exiting the employee data. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
