package com.example.clinc_mangement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Lab_Test extends Utilites implements Initializable {
    private String test_name;
    private double Cost;
    public Lab_Test(){}
    public Lab_Test(String product_name, double cost, String test_name, double cost1) {
        super(product_name, cost);
        this.test_name = test_name;
        Cost = cost1;
    }

    public Lab_Test(String text, double cost) {
    }

    public String getTest_name() {
        return test_name;
    }

    public void setTest_name(String test_name) {
        this.test_name = test_name;
    }
    public double getCost() {
        return Cost;
    }

    public void setCost(double cost) {
        Cost = cost;
    }

    public ArrayList<Lab_Test> L = new ArrayList<>();
    public HelloApplication h = new HelloApplication();

    @FXML
    private TextField L_cost;
    @FXML
    private TextField L_testname;
    @FXML
    private ImageView imgLab_Test;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/image/imgLab_Test.jpeg");
        Image img = new Image(file.toURI().toString());
        imgLab_Test.setImage(img);
    }

    @FXML
    public void L_add(ActionEvent event) {
        try {
            L.add(new Lab_Test(L_testname.getText(),Double.parseDouble(L_cost.getText())));
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
    public void phbnt(ActionEvent event) {
        try {
            h.changescene("Pharmacy.fxml");
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