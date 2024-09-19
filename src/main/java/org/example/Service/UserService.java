package org.example.Service;

import org.example.Model.User;
import org.example.Pattern.validator;
import org.example.Repo.UserInterface;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UserService implements UserInterface {
    database db = new database();
    Scanner sc = new Scanner(System.in);
    ArrayList<User> users = new ArrayList<>();

    @Override
    public void displyAllUser() {
        try {
            users = (ArrayList<User>) db.getAllUsers();
            for(int i= 0;i<= users.size()-1;i++){
                System.out.println(users.get(i)+" ");
            }
         /*   for (User user : users) {
                System.out.println(user);
            }*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String insertUser(User user) {

        System.out.println("Address:");
        user.setAddress(sc.next());
        if (!validator.validAddress(user.getAddress())) throw new RuntimeException("Invalid address");

        System.out.println("Age:");
        user.setAge(sc.nextInt());
        if (!validator.validAge(user.getAge())) throw new RuntimeException("Invalid age");

        System.out.println("Company:");
        user.setCompany(sc.next());
        if (!validator.isValidCompanyName(user.getCompany())) throw new RuntimeException("Invalid company name");

        System.out.println("Id:");
        user.setId(sc.nextInt());
        if (!validator.validId(user.getId())) throw new RuntimeException("Invalid ID");

        System.out.println("Department:");
        user.setDepartment(sc.next());
        if (!validator.validDepartment(user.getDepartment())) throw new RuntimeException("Invalid department");

        System.out.println("Email:");
        user.setEmail(sc.next());
        if (!validator.validEmail(user.getEmail())) throw new RuntimeException("Invalid email");

        System.out.println("Name:");
        user.setName(sc.next());
        if (!validator.validfirstname(user.getName())) throw new RuntimeException("Invalid first name");

        System.out.println("LastName:");
        user.setLastName(sc.next());
        if (!validator.isValidLastName(user.getLastName())) throw new RuntimeException("Invalid last name");

        System.out.println("PhoneNumber:");
        user.setPhoneNumber(sc.nextLong());
        if (!validator.validPhoneNumber(user.getPhoneNumber())) throw new RuntimeException("Invalid phone number");

        System.out.println("Salary:");
        user.setSalary(sc.nextInt());
        if (!validator.validSalary(user.getSalary())) throw new RuntimeException("Invalid salary");

        try {
            db.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user.toString();
    }

    @Override
    public void deleteUser(int id) {
        try {
            db.deleteFromDB(id);
            Iterator<User> i = users.iterator();
            while (i.hasNext()) {
                User user = i.next();
                if (user.getId() == id) {
                    i.remove();
                    System.out.println("Data deleted successfully");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateUser(int id) {
        try {
            for (User user : users) {
                if (user.getId() == id)//
                {
                    System.out.println("Enter Updated Name:");
                    user.setName(sc.next());
                    if (!validator.validfirstname(user.getName())) throw new RuntimeException("Invalid first name");

                    System.out.println("Enter Updated Last Name:");
                    user.setLastName(sc.next());
                    if (!validator.isValidLastName(user.getLastName())) throw new RuntimeException("Invalid last name");

                    System.out.println("Enter Updated Age:");
                    user.setAge(sc.nextInt());
                    if (!validator.validAge(user.getAge())) throw new RuntimeException("Invalid age");

                    System.out.println("Enter Updated Salary:");
                    user.setSalary(sc.nextInt());
                    if (!validator.validSalary(user.getSalary())) throw new RuntimeException("Invalid salary");

                    System.out.println("Enter Updated Department:");
                    user.setDepartment(sc.next());
                    if (!validator.validDepartment(user.getDepartment())) throw new RuntimeException("Invalid department");

                    System.out.println("Enter Updated Phone Number:");
                    user.setPhoneNumber(sc.nextLong());
                    if (!validator.validPhoneNumber(user.getPhoneNumber())) throw new RuntimeException("Invalid phone number");

                    System.out.println("Enter Updated Email:");
                    user.setEmail(sc.next());
                    if (!validator.validEmail(user.getEmail())) throw new RuntimeException("Invalid email");

                    System.out.println("Enter Updated Address:");
                    user.setAddress(sc.next());
                    if (!validator.validAddress(user.getAddress())) throw new RuntimeException("Invalid address");

                    System.out.println("Enter Updated Company:");
                    user.setCompany(sc.next());
                    if (!validator.isValidCompanyName(user.getCompany())) throw new RuntimeException("Invalid company name");

                    db.updatedb(user);
                    System.out.println("User updated successfully");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

