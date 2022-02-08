package com.unique.pack;

public class Person {

    private final String FIRST_NAME;
    private final String LAST_NAME;
    private int age;
    private double weight;
    private double height;

    public Person(String firstName, String lastName) {
        this.FIRST_NAME = firstName;
        this.LAST_NAME = lastName;
    }

    public Person(String firstName, String lastName, int age, double weight, double height) {
        this.FIRST_NAME = firstName;
        this.LAST_NAME = lastName;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "FIRST_NAME='" + FIRST_NAME + '\'' +
                ", LAST_NAME='" + LAST_NAME + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
