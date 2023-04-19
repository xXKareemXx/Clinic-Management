package com.example.clinc_mangement;

public class Admin {
    private static Admin admin;
    public String value;
    private Admin(String value){
        this.value = value;
    }
    public static Admin getAdmin(String name){
        if(admin == null)
            admin = new Admin(name);
        return admin;
    }
}