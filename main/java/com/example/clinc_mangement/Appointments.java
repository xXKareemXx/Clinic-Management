package com.example.clinc_mangement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class Appointments implements Initializable {
    private String patient_name;
    private String doctor_name;
    private String clinic;
    private LocalDate appointment_date;
    public Appointments(){}
    public Appointments(String patient_name, String doctor_name, String clinic, LocalDate appointment_date) {
        this.patient_name = patient_name;
        this.doctor_name = doctor_name;
        this.clinic = clinic;
        this.appointment_date = appointment_date;
    }

    public Appointments(String text, String text1, String text2, String text3) {
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public LocalDate getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(LocalDate appointment_date) {
        this.appointment_date = appointment_date;
    }


    public ArrayList<Appointments> A = new ArrayList<>();
    public HelloApplication h = new HelloApplication();
    @FXML
    private TextField a_patname;
    @FXML
    private TextField a_docname;
    @FXML
    private TextField a_clinic;
    @FXML
    private DatePicker a_date;
    @FXML
    private ImageView imgAppointments;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/image/imgAppointments.jpeg");
        Image img = new Image(file.toURI().toString());
        imgAppointments.setImage(img);
    }
    @FXML
    public void a_add(ActionEvent event) {
        try {
            A.add(new Appointments(a_patname.getText(),a_docname.getText(),a_clinic.getText(), a_date.getValue()));
        }catch(Exception e){
            e.printStackTrace();
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
}