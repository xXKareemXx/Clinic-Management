package com.example.clinc_mangement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.*;

public class Login implements Initializable {
    public String username;
    public String poisition;
    public int password;
    public Login(){}

    public Login(String username, String poisition, int password) {
        this.username = username;
        this.poisition = poisition;
        this.password = password;
    }
    public HelloApplication h = new HelloApplication();
    @FXML
    private TextField L_username;
    @FXML
    private TextField L_position;
    @FXML
    private TextField L_password;
    @FXML
    private ImageView imgLogin;
    Thread K = new Thread(() -> {
        Admin admin = Admin.getAdmin("Kareem");
        System.out.println(admin.value);
    });
    Thread A = new Thread(() -> {
        Admin ad = Admin.getAdmin("Aya");
        System.out.println(ad.value);
    });
    Thread R = new Thread(() -> {
        Admin ad = Admin.getAdmin("Raneem");
        System.out.println(ad.value);
    });
        public String k = K.toString();
        public String a = A.toString();
        public String r = R.toString();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/image/imgLogin.jpg");
        Image img = new Image(file.toURI().toString());
        imgLogin.setImage(img);
    }
    @FXML
    public void dbnt(ActionEvent event){
        if(L_position.getText().isEmpty() || L_username.getText().isEmpty() || L_password.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
//        }else if(L_position.getText() == "admin" && L_username.getText() == r && L_password.getText() == "0000"){
//            try {
//                h.changescene("Doctor.fxml");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
        else{
            try {
                h.changescene("Doctor.fxml");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}




