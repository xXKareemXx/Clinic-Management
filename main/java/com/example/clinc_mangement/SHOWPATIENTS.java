package com.example.clinc_mangement;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.*;

import java.util.logging.*;

public class SHOWPATIENTS {
    String query = null;
    Connection connection = null;
    PreparedStatement preparedStatement = null ;
    ResultSet resultSet = null ;

    ObservableList<Patient> patients = FXCollections.observableArrayList();
   // @FXML
//    @FXML
//    private void refreshTable() {
//        try {
//            patients.clear();
//
//            query = "SELECT * FROM `patient`";
//            preparedStatement = connection.prepareStatement(query);
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                StudentList.add(new Patient(
//                        resultSet.getInt("id"),
//                        resultSet.getString("name"),
//                        resultSet.getDate("birth"),
//                        resultSet.getString("adress"),
//                        resultSet.getString("email")));
//                studentsTable.setItems(StudentList);
//
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
//}