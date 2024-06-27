package com.example.homepractice;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HelloApplication extends Application {

    private TableView<Person> table;
    private ObservableList<Person> data;
    private TextField nameInput, ageInput;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("28. Alkalom");

        // Táblázat
        table = new TableView<>();
        data = FXCollections.observableArrayList();
        table.setItems(data);

        TableColumn<Person, String> nameColumn = new TableColumn<>("Név");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());

        TableColumn<Person, Integer> ageColumn = new TableColumn<>("Kor");
        ageColumn.setMinWidth(100);
        ageColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());

        table.getColumns().addAll(nameColumn, ageColumn);

        // Beviteli mezők
        nameInput = new TextField();
        nameInput.setPromptText("Név");
        nameInput.setMinWidth(100);

        ageInput = new TextField();
        ageInput.setPromptText("Kor");

        // Gombok
        Button addButton = new Button("Hozzáadás");
        addButton.setOnAction(e -> addButtonClicked());

        Button deleteButton = new Button("Törlés");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, ageInput, addButton, deleteButton);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Adat hozzáadása
    private void addButtonClicked() {
        Person person = new Person();
        person.setName(nameInput.getText());
        person.setAge(Integer.parseInt(ageInput.getText()));
        data.add(person);
        nameInput.clear();
        ageInput.clear();
    }

    // Adat törlése
    private void deleteButtonClicked() {
        ObservableList<Person> selected, all;
        all = table.getItems();
        selected = table.getSelectionModel().getSelectedItems();

        selected.forEach(all::remove);
    }
}