package com.example.springapi;

public class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private String emailAddress;
    private String homeAddres;
    private String role;

    public String getFirstName() {
        return firstName;
    }

    public Employee() {
    }

    public Employee(String firstName, String lastName, int age,
                    String emailAddress, String homeAddres, String role)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.emailAddress = emailAddress;
        this.homeAddres = homeAddres;
        this.role = role;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getHomeAddres() {
        return homeAddres;
    }

    public void setHomeAddres(String homeAddres) {
        this.homeAddres = homeAddres;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
