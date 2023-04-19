package com.example.clinc_mangement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Costumer_Service extends Person implements Money{
    private int id;
    private int password;
    private int work_time;

    public Costumer_Service() {
    }

    public Costumer_Service(String name, String address, int age, int phone_number, int id, int password, int work_time) {
        super(name, address, age, phone_number);
        this.id = id;
        this.password = password;
        this.work_time = work_time;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getWork_time() {
        return work_time;
    }

    public void setWork_time(int work_time) {
        this.work_time = work_time;
    }

    public Double clac_salary(){return 200.0*work_time;}
    public Double payment(){return null;}

    public String toString() {
        return "Name: " + getName() + "Age: " + getAge() +
                "id: " + id + "password: " + password;
    }

    public ArrayList<Costumer_Service> S = new ArrayList<>();
    public HelloApplication h = new HelloApplication();
    @FXML
    public void dbnt(ActionEvent event){
        try {
            h.changescene("Doctor.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void pbnt(ActionEvent event){
        try {
            h.changescene("Patient.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void abnt(ActionEvent event) {
        try {
            h.changescene("Appointments.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void phbnt(ActionEvent event) {
        try {
            h.changescene("Pharmacy.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ltbnt(ActionEvent event) {
        try {
            h.changescene("Lab_Test.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void bdbnt(ActionEvent event) {
        try {
            h.changescene("Blood_Donation.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void cbnt(ActionEvent event) {
        try {
            h.changescene("Clinics.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void lbnt(ActionEvent event) {
        try {
            h.changescene("Login.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sdbtn(ActionEvent event) {
        try {
            h.changescene("SHOW DOCTOR.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void spbtn(ActionEvent event) {
        try {
            h.changescene("SHOW PATIENT.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void smbtn(ActionEvent event) {
        try {
            h.changescene("SHOW PHARMACY.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sabtn(ActionEvent event) {
        try {
            h.changescene("SHOW APPOINMENTS.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sbbtn(ActionEvent event) {
        try {
            h.changescene("SHOW BLOOD DONATION.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stbtn(ActionEvent event) {
        try {
            h.changescene("SHOW TEST.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
