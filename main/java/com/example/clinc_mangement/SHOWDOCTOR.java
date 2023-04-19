package com.example.clinc_mangement;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SHOWDOCTOR {

    @FXML
    private TableView<Doctor> table_doctor;
    @FXML
    private TableColumn<Doctor, Integer> did;
    @FXML
    private TableColumn<Doctor, String> dname;
    @FXML
    private TableColumn<Doctor, Integer> dage;
    @FXML
    private TableColumn<Doctor, Integer> dphone;

    @FXML
    private TableColumn<Doctor, String> dspecialist;

    @FXML
    private TableColumn<Doctor, Double> dsalary;

    @FXML
    private TableColumn<Doctor, String> dexperience;
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    ObservableList<Doctor> doctors = FXCollections.observableArrayList();
    @FXML
    public void drefresh() {
        connection = DBconnection.getConnect();
        try {
            doctors.clear();
            query = "SELECT * FROM doctor";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                doctors.add(new Doctor(
                        resultSet.getString("name"),
                        resultSet.getInt("id"),
                        resultSet.getString("address"),
                        resultSet.getInt("age"),
                        resultSet.getInt("phone_number"),
                        resultSet.getString("specialist"),
                        resultSet.getDouble("salary"),
                        resultSet.getInt("work_time"),
                        resultSet.getString("experience")));
                table_doctor.setItems(doctors);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SHOWDOCTOR.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ddelete(ActionEvent event) {
        connection = DBconnection.getConnect();
        try {
            ResultSet rs;
            String sql = "DELETE FROM doctor WHERE id=?";
            String selecteditem = String.valueOf(table_doctor.getSelectionModel().getSelectedItem());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2, did.getText());
            statement.execute();
            int selctedid = table_doctor.getSelectionModel().getSelectedIndex();
            table_doctor.getItems().remove(selctedid);
        }catch(SQLException ex){
            Logger.getLogger(Doctor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
