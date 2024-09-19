package org.example.Service;

import org.example.Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class database {
    public static String url = "jdbc:mysql://localhost:3306/Employee?createDatabaseIfNotExist=true&useSSL=true";
    public static String username = "root";
    public static String password = "Ashish@123";
    public static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS EMPLOYEETB " +
            "(ID INT PRIMARY KEY, NAME VARCHAR(90), LASTNAME VARCHAR(95), AGE INT, SALARY INT, " +
            "DEPARTMENT VARCHAR(90), PHONENUMBER VARCHAR(95), EMAIL VARCHAR(99), ADDRESS VARCHAR(90), COMPANY VARCHAR(90))";
    public static String INSERT_QUERY = "INSERT INTO EMPLOYEETB (ID, NAME, LASTNAME, AGE, SALARY, DEPARTMENT, PHONENUMBER, EMAIL, ADDRESS, COMPANY) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
public static String update_query="UPDATE EMPLOYEETB SET  NAME=? ,LASTNAME=? ,AGE=? ,SALARY=? ,DEPARTMENT=? ,PHONENUMBER=? ,EMAIL=? ,ADDRESS=? ,COMPANY=? WHERE ID=?";
    public database() {
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement st = con.createStatement()) {
            st.execute(CREATE_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    // Insert User data into the database
    public void create(User user) throws SQLException {
        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement st = con.prepareStatement(INSERT_QUERY)) {
            st.setInt(1, user.getId());
            st.setString(2, user.getName());
            st.setString(3, user.getLastName());
            st.setInt(4, user.getAge());
            st.setInt(5, user.getSalary());
            st.setString(6, user.getDepartment());
            st.setLong(7, user.getPhoneNumber());
            st.setString(8, user.getEmail());
            st.setString(9, user.getAddress());
            st.setString(10, user.getCompany());
            st.executeUpdate();
        }
    }

    // Retrieve User data from the database
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM EMPLOYEETB";
        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("NAME"));
                user.setLastName(rs.getString("LASTNAME"));
                user.setAge(rs.getInt("AGE"));
                user.setSalary(rs.getInt("SALARY"));
                user.setDepartment(rs.getString("DEPARTMENT"));
                user.setPhoneNumber(rs.getLong("PHONENUMBER"));
                user.setEmail(rs.getString("EMAIL"));
                user.setAddress(rs.getString("ADDRESS"));
                user.setCompany(rs.getString("COMPANY"));
                users.add(user);
            }
        }
        return users;
    }



        public void updatedb(User user) throws SQLException {
            try (Connection con = DriverManager.getConnection(url, username, password);
                 PreparedStatement st = con.prepareStatement(update_query)) {
                 con.setAutoCommit(false);  // Start transaction
                st.setString(1, user.getName());
                st.setString(2, user.getLastName());
                st.setInt(3, user.getAge());
                st.setInt(4, user.getSalary());
                st.setString(5, user.getDepartment());
                st.setLong(6, user.getPhoneNumber());
                st.setString(7, user.getEmail());
                st.setString(8, user.getAddress());
                st.setString(9, user.getCompany());
                st.setInt(10, user.getId());

                int rowsUpdated = st.executeUpdate();
                if (rowsUpdated > 0) {
                    con.commit();  // Commit the transaction
                   // System.out.println("Update successful, transaction committed.");
                } else {
                    con.rollback();  // Rollback in case no rows were updated
                   // System.out.println("No rows updated, transaction rolled back.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
        //@Override

        public void deleteFromDB(int id) throws SQLException {
            String delete_query = "DELETE FROM EMPLOYEETB WHERE ID = ?";
            try (Connection con = DriverManager.getConnection(url, username, password);
                 PreparedStatement st = con.prepareStatement(delete_query)) {
                con.setAutoCommit(false);  // Start transaction

                st.setInt(1, id);

                int rowsDeleted = st.executeUpdate();
                if (rowsDeleted > 0) {
                    con.commit();  // Commit the transaction
                    System.out.println("Deletion successful, transaction committed.");
                } else {
                    con.rollback();  // Rollback in case no rows were deleted
                    System.out.println("No rows deleted, transaction rolled back.");
                }
            } catch (SQLException e) {
                e.printStackTrace();



    }

}

    }

