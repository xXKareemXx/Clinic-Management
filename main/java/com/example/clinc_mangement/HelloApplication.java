package com.example.clinc_mangement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    public ArrayList<Person> p;
    public ArrayList<Utilites> u;
    private static Stage st;
    @Override
    public void start(Stage stage) throws IOException {
        st = stage;
        stage.setResizable(false);
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 400);
        stage.setTitle("Login!");
        stage.setScene(scene);
        stage.show();
        DBconnection d = new DBconnection();
        d.getConnect();
    }
    public void changescene(String s) throws IOException {
        st.setResizable(false);
        FXMLLoader fxml = new FXMLLoader(getClass().getResource(s));
        Scene scene = new Scene(fxml.load(), 600, 400);
        st.setTitle("");
        st.setScene(scene);
        st.show();
    }
    public static void main(String[] args) {
        launch();
    }
}