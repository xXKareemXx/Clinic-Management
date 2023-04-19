package com.example.clinc_mangement;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Clinics implements Initializable{
    public String clinic_name;
    public String room_number;
    public String day;

    public Clinics(){}
    public Clinics(String clinic_name, String room_number, String day) {
        this.clinic_name = clinic_name;
        this.room_number = room_number;
        this.day = day;
    }

//    Clinics[] clinics = {new Clinics("ENT", "6", "sunday"),
//            new Clinics("Eye_Clinic", "5", "monday"), new Clinics("Dentistry", "12", "sunday"),
//            new Clinics("Eye_Clinic", "2", "teusday"), new Clinics("Dentistry", "10", "wednseday"),
//            new Clinics("ENT", "10", "wednseday"), new Clinics("ENT", "10", "monday"),
//            new Clinics("Eye_Clinic", "17", "thursday")};

    public String getClinic_name() {
        return clinic_name;
    }

    public void setClinic_name(String clinic_name) {
        this.clinic_name = clinic_name;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getDays() {
        return day;
    }

    public void setDay(String day) {this.day = day;}

    public HelloApplication h = new HelloApplication();
    @FXML
    private TextField c_clinic_name;
    @FXML
    private TextField c_available_days;
    @FXML
    private TextField c_room_num;
    @FXML
    private ImageView imgClinics;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/image/imgClinics.png");
        Image img = new Image(file.toURI().toString());
        imgClinics.setImage(img);
    }

    @FXML
    public void c_add(ActionEvent event){
        if(c_clinic_name.getText() == "enr") {
            c_available_days.setText("Sunday");
            c_room_num.setText("142");
        }else if(c_clinic_name.getText() == "dentistry"){
            c_available_days.setText("Monday");
            c_room_num.setText("100");
        }else if(c_clinic_name.getText() == "eyeclinic"){
            c_available_days.setText("Saturday");
            c_room_num.setText("50");
        }
    }

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
    public void csbnt(ActionEvent event) {
        try {
            h.changescene("Costumer_Service.fxml");
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

    public void lbnt(ActionEvent event) {
        try {
            h.changescene("Login.fxml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



