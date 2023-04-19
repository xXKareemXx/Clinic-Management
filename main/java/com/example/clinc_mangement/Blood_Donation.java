package com.example.clinc_mangement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Blood_Donation implements Initializable {
    private String blood_type;
    private String donator_name;

    public Blood_Donation(){}

    public Blood_Donation(String blood_type, String donator_name) {
        this.blood_type = blood_type;
        this.donator_name = donator_name;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public void setBlood_type(String blood_type) {
        this.blood_type = blood_type;
    }

    public String getDonar_health() {
        return donator_name;
    }

    public void setDonar_health(String donar_health) {
        this.donator_name = donar_health;
    }

    public ArrayList<Blood_Donation> B = new ArrayList<>();
    public HelloApplication h = new HelloApplication();
    @FXML
    private TextField B_donator_name;
    @FXML
    private TextField B_blood_type;
    @FXML
    private ImageView imgBlood_Donation;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/image/imgBlood_Donation.jpeg");
        Image img = new Image(file.toURI().toString());
        imgBlood_Donation.setImage(img);
    }
    @FXML
       public void B_add(ActionEvent event) {
          try {
           B.add(new Blood_Donation(B_blood_type.getText(),B_donator_name.getText()));
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
    public void ltbnt(ActionEvent event) {
        try {
            h.changescene("Lab_Test.fxml");
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
