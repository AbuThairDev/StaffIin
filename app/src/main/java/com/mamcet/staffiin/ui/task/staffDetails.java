package com.mamcet.staffiin.ui.task;

public class staffDetails {
    String id;
    String phone_number;
    String dob ;
    String qualification;
    String address;
    String name;
    String role;
    String email;
    String password;



    public staffDetails(String id, String phone_number, String dob, String qualification, String address, String role, String email, String name) {
        this.id = id;
        this.phone_number = phone_number;
        this.dob = dob;
        this.qualification = qualification;
        this.address = address;
        this.name = name;
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getDob() {
        return dob;
    }

    public String getQualification() {
        return qualification;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
