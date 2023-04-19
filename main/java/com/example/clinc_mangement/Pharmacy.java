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
import java.util.ArrayList;
import java.util.Date;

public class Pharmacy extends Utilites implements Initializable {
    private LocalDate medicine_exp;
    private String for_what_disease;

    public Pharmacy(){super();}

    public Pharmacy(String product_name, double cost, LocalDate medicine_exp, String for_what_disease) {
        super(product_name, cost);
        this.medicine_exp = medicine_exp;
        this.for_what_disease = for_what_disease;
    }

    public LocalDate getMedicine_exp() {
        return medicine_exp;
    }

    public void setMedicine_exp(LocalDate medicine_exp) {
        this.medicine_exp = medicine_exp;
    }

    public String getFor_what_disease() {
        return for_what_disease;
    }

    public void setFor_what_disease(String for_what_disease) {
        this.for_what_disease = for_what_disease;
    }


    public ArrayList<Pharmacy> P = new ArrayList<>();
    public HelloApplication h = new HelloApplication();
    @FXML
    private TextField P_productname;
    @FXML
    private TextField P_cost;
    @FXML
    private DatePicker P_date;
    @FXML
    private TextField P_disease;
    @FXML
    private ImageView imgPharmacy;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/image/imgPharmacy.jpeg");
        Image img = new Image(file.toURI().toString());
        imgPharmacy.setImage(img);
    }
    @FXML
    public void p_add(ActionEvent event) {
        try {
            P.add(new Pharmacy(P_productname.getText(),Double.parseDouble(P_cost.getText()),P_date.getValue(), P_disease.getText()));
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
    public void abnt(ActionEvent event) {
        try {
            h.changescene("Appointments.fxml");
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