package com.example.clinc_mangement;

public abstract  class Person {
    private String name;
    private String address;
    private int age;
    private int phone_number;

    public Person(String name, String address, int age, int phone_number) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.phone_number = phone_number;
    }
    public Person() {}
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public abstract String toString();
}
