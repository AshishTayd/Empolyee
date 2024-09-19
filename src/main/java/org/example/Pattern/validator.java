package org.example.Pattern;

public class validator {
    public static boolean validfirstname(String name) {
        return name.matches("[A-Z][a-z]*");
    }

    public static boolean isValidLastName(String lastName) {
        return lastName.matches("[A-Z][a-z]*");
    }

    public static boolean validEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public static boolean validAddress(String address) {
        return address.matches("^[a-zA-Z0-9\\s,'-]+$");
    }

    public static boolean validPhoneNumber(long phoneNumber) {
        String phone = Long.toString(phoneNumber);
        return phone.matches("\\d{10}");
    }

    public static boolean validAge(int age) {
        return age > 0 && age < 120;
    }

    public static boolean validSalary(int salary) {
        return salary >= 0;
    }

    public static boolean validId(int id) {
        return id > 0;
    }

    public static boolean validDepartment(String department) {
        return department.matches("[A-Z][a-z]*");
    }

    public static boolean isValidCompanyName(String company) {
        return company.matches("[A-Z][a-zA-Z0-9\\s]*");
    }
}
