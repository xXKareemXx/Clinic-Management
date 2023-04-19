package com.example.clinc_mangement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

public class Doctor extends Person implements Money, Initializable {
    private int id;
    private String specialist;
    private double salary;
    private int work_time;
    private String experience;
    public Doctor(){
        super();
    }

    public Doctor(String name, int id, String address, int age, int phone_number,
                  String specialist, double salary, int work_time, String experience) {
        super(name, address, age, phone_number);
        this.id = id;
        this.specialist = specialist;
        this.salary = salary;
        this.work_time = work_time;
        this.experience = experience;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getSpecialist() {
        return specialist;
    }
    public double getSalary() {
        return salary;
    }
    public int getWork_time() {
        return work_time;
    }
    public String getExperience() {
        return experience;
    }
    public void setSpecialist(String specialist) {
        this.specialist = specialist;
    }
    public void setSalary(double salary) {
        salary = salary;
    }
    public void setWork_time(int work_time) {
        this.work_time = work_time;
    }
    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String toString(){
        return "Name: "+getName()+"Age: "+getAge()+"Specialist: "+specialist
                +"Salary: "+salary+"Experience: "+experience+"WorkingTime: "+work_time;
    }
    public Double clac_salary(){
        return Double.parseDouble(d_salary.getText())*Double.parseDouble(d_work.getText());
    }
    public Double payment(){return null;}
    public ArrayList<Doctor> D = new ArrayList<>();
    public HelloApplication h = new HelloApplication();
    @FXML
    private TextField d_name;
    @FXML
    private TextField d_id;
    @FXML
    private TextField d_age;
    @FXML
    private TextField d_phone;
    @FXML
    private TextField d_spec;
    @FXML
    private TextField d_salary;
    @FXML
    private TextField d_work;
    @FXML
    private TextField d_exp;
    @FXML
    private TextField d_add;
    @FXML
    private ImageView imgDoctor;

    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/image/imgDoctor.jpeg");
        Image img = new Image(file.toURI().toString());
        imgDoctor.setImage(img);
    }
    @FXML
    public void b_clear(ActionEvent event){
        String s = " ";
        d_name.setText(s);
        d_id.setText(s);
        d_age.setText(s);
        d_phone.setText(s);
        d_spec.setText(s);
        d_salary.setText(s);
        d_work.setText(s);
        d_exp.setText(s);
        d_add.setText(s);
    }
    public void b_add(ActionEvent event) {
        connection = DBconnection.getConnect();
            D.add(new Doctor(d_name.getText(), Integer.parseInt(d_id.getText()), d_add.getText(),
                    Integer.parseInt(d_age.getText()), Integer.parseInt(d_phone.getText()), d_spec.getText(),
                    Double.parseDouble(d_salary.getText()), Integer.parseInt(d_work.getText()), d_exp.getText()));
            String name = d_name.getText();
            int id = Integer.parseInt(d_id.getText());
            int age = Integer.parseInt(d_age.getText());
            int phone = Integer.parseInt(d_phone.getText());
            String spec = d_spec.getText();
            Double salary = Double.parseDouble(d_age.getText());
            Integer worktime = Integer.parseInt(d_work.getText());
            String exp = d_exp.getText();
            String address = d_add.getText();
            if (name.isEmpty() || String.valueOf(id).isEmpty() || String.valueOf(age).isEmpty() || String.valueOf(phone).isEmpty()
            || spec.isEmpty() || String.valueOf(salary).isEmpty() || String.valueOf(worktime).isEmpty() || exp.isEmpty() || address.isEmpty()) {
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
        query = "INSERT INTO doctor(name,id,age,phone,address,experience,salary,specialist) VALUES (?,?,?,?,?,?,?,?)";
    }
    private void insert() {
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, d_name.getText());
            preparedStatement.setString(2, d_id.getText());
            preparedStatement.setString(3, d_age.getText());
            preparedStatement.setString(4, d_phone.getText());
            preparedStatement.setString(5, d_add.getText());
            preparedStatement.setString(6, d_exp.getText());
            preparedStatement.setString(7, String.valueOf(clac_salary()));
            preparedStatement.setString(8, d_spec.getText());
            preparedStatement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
//        void setTextField(int id, String name, LocalDate toLocalDate, String adress, String email) {
//
//            studentId = id;
//            nameFld.setText(name);
//            birthFld.setValue(toLocalDate);
//            adressFld.setText(adress);
//            emailFld.setText(email);
//
//        }
//
//        void setUpdate(boolean b) {
//            this.update = b;
//
//        }
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