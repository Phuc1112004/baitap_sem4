package com.example.entity;


import java.util.scan
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private double mark;

    public student() {

    }

    public Student(int id, String firstName,String lastName,double mark ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mark = mark;
    }

    public void scanInfo() {
        Scanner scaner = new Scanner(System.in);
        System.out.print ("Enter Id: ");
        this.id = Sanner.nextInt();
        System.out.print ("Enter First Name: ");
        this.firstName = Sanner.nextLine();
        System.out.print ("Enter Last Name: ");
        this.lastName = Sanner.nextLine();
        System.out.print ("Enter Mark: ");
        this.mark = Sanner.nextDouble();
    }

    public void printInfo() {
        System.out.println("%3d|%10s|%10s|%5f\n",getId(),getFirstName(),getLastName,getMark());
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getMark() {
        return mark;
    }
}