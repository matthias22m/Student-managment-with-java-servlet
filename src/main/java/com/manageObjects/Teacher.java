package com.manageObjects;

public class Teacher {
    private String teach_id;
    private String full_name;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private int hour_limit;
    private String password;


    public void setTeachId(String teach_id) {
        this.teach_id = teach_id;
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
    public void setHourLimit(int hour_limit) {
        this.hour_limit = hour_limit;
    }

    public String getTeachId() {
        return this.teach_id;
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
    public int getHourLimit() {
        return this.hour_limit;
    }
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
