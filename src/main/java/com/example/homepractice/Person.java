package com.example.homepractice;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {

    private final SimpleStringProperty name;
    private final SimpleIntegerProperty age;

    public Person() {
        this.name = new SimpleStringProperty();
        this.age = new SimpleIntegerProperty();
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public int getAge() {
        return age.get();
    }

    public void setAge(int age) {
        this.age.set(age);
    }

    public SimpleIntegerProperty ageProperty() {
        return age;
    }
}
