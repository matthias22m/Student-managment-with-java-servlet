package com.manageObjects;

public class Student {
    private String stud_id;
    private String full_name;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private int year;
    private String password;


    public void setStudId(String stud_id) {
        this.stud_id = stud_id;
    }
    public void setFullName(String full_name) {
        this.full_name = full_name;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String getStudId() {
        return this.stud_id;
    }
    public String getFullName() {
        return this.full_name;
    }
    public String getGender() {
        return this.gender;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPhone() {
        return this.phone;
    }
    public String getAddress() {
        return this.address;
    }
    public int getYear() {
        return this.year;
    }
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
