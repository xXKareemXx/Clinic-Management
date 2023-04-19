package com.example.clinc_mangement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.security.auth.login.LoginContext;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Patient extends Person implements Money, Initializable {
    private String gender;
    private String suffers_from;
    private double height;
    private double weight;
    private int num_medicne;
    private int tests;

    public Patient(){}

    public Patient(String name, String address, int age, int phone_number, String gender, String suffers_from, double height, double weight, int num_medicne, int tests) {
        super(name, address, age, phone_number);
        this.gender = gender;
        this.suffers_from = suffers_from;
        this.height = height;
        this.weight = weight;
        this.num_medicne = num_medicne;
        this.tests = tests;
    }

    public String getSuffers_from() {
        return suffers_from;
    }

    public void setSuffers_from(String suffers_from) {
        this.suffers_from = suffers_from;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getNum_medicne() {
        return num_medicne;
    }

    public void setNum_medicne(int num_medicne) {
        this.num_medicne = num_medicne;
    }

    public int getTests() {
        return tests;
    }

    public void setTests(int tests) {
        this.tests = tests;
    }

    public String toString(){
        return "Name: "+getName()+"Age: "+getAge()+"height: "+height+"weight: "+weight+"suffers_from: "+suffers_from;
    }
    public Double clac_salary(){
        return null;
    }
    public Double payment(){
        Doctor d = new Doctor();
        Lab_Test t = new Lab_Test();
        double quantity_salary=num_medicne*30+t.getCost()+d.getSalary();
        return quantity_salary;
    }
    public ArrayList<Patient> p = new ArrayList<Patient>();
    HelloApplication h = new HelloApplication();

    @FXML
    private TextField p_name;
    @FXML
    private TextField p_age;
    @FXML
    private TextField p_phone;
    @FXML
    private TextField p_add;
    @FXML
    private TextField p_height;
    @FXML
    private TextField p_weight;
    @FXML
    private TextField p_suffer;
    @FXML
    private TextField p_gender;
    @FXML
    private TextField p_num;
    @FXML
    private TextField p_tests;
    @FXML
    private ImageView imgPatient;
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/image/imgPatient.jpeg");
        Image img = new Image(file.toURI().toString());
        imgPatient.setImage(img);
    }
    public void p_add(ActionEvent event) {
        connection = DBconnection.getConnect();
        //p.add(new Patient(p_.getText(), Integer.parseInt(d_id.getText()), d_add.getText(),
          //      Integer.parseInt(d_age.getText()), Integer.parseInt(d_phone.getText()), d_spec.getText(),
            //    Double.parseDouble(d_salary.getText()), Integer.parseInt(d_work.getText()), d_exp.getText()));
        String name = p_name.getText();
        int weight = Integer.parseInt(p_weight.getText());
        int age = Integer.parseInt(p_age.getText());
        int phone = Integer.parseInt(p_phone.getText());
        String tests = p_tests.getText();
        String quantity = p_num.getText();
        int height = Integer.parseInt(p_height.getText());
        String suff = p_suffer.getText();
        String add = p_add.getText();

        if (name.isEmpty() || String.valueOf(weight).isEmpty() || String.valueOf(age).isEmpty() || String.valueOf(phone).isEmpty()
                || tests.isEmpty() || String.valueOf(height).isEmpty() || String.valueOf(age).isEmpty() || add.isEmpty() || add.isEmpty() ||
        suff.isEmpty() || quantity.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Fill All DATA");
            alert.showAndWait();
        } else {
            getQuery();
            insert();
        }
    }
    private void getQuery() {
        query = "INSERT INTO patient(name,suffer,age,phone,address,gender,weight,height,payment) VALUES (?,?,?,?,?,?,?,?,?)";
    }
    private void insert() {
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, p_name.getText());
            preparedStatement.setString(2, p_suffer.getText());
            preparedStatement.setString(3, p_age.getText());
            preparedStatement.setString(4, p_phone.getText());
            preparedStatement.setString(5, p_add.getText());
            preparedStatement.setString(6, p_gender.getText());
            preparedStatement.setString(7, p_weight.getText());
            preparedStatement.setString(8, p_height.getText());
            preparedStatement.setString(9, String.valueOf(payment()));
            preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void dbnt(ActionEvent event) {
        try {
            h.changescene("Doctor.fxml");
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
    public void p_clear(ActionEvent event) {
        String s = " ";
        p_name.setText(s);
        p_suffer.setText(s);
        p_weight.setText(s);
        p_phone.setText(s);
        p_add.setText(s);
        p_gender.setText(s);
        p_height.setText(s);
        p_age.setText(s);
        p_num.setText(s);
        p_tests.setText(s);
    }
}