package com.example.digilog;

public class storingdata {
    String fullname,email,mobilenumber,department,year,password;

    public storingdata() {

    }

    public storingdata(String fullname, String email, String mobilenumber, String department, String year, String password) {
        this.fullname = fullname;
        this.email = email;
        this.mobilenumber = mobilenumber;
        this.department = department;
        this.year = year;
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

