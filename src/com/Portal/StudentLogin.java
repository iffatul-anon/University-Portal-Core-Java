package com.Portal;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Profile {
    int id;
    String name;
    String dateOfBirth;
    String fatherName;
    String motherName;
    String designation;
    String department;
    String email;
    String phone;
    String address;
    String bloodGroup;
    String religion;
}

class Password {
    int id;
    String password;
}

class StudentWaiver {
    int id;
    float givenWaiver;
    float requiredSGPA;
}

class StudentResult {
    int id;
    float sgpa;
    String subject;
    float averageQuiz, quiz1, quiz2, quiz3;
    float assignment;
    float presentation;
    float attendance;
    float midterm;
    float finalExam;
    float total;
    float gradePoint;
    float labPerformance;
    float labReport;
    float proposal;
}

public class StudentLogin {
    static Profile student = new Profile();
    static Password pass = new Password();
    static StudentWaiver waiver = new StudentWaiver();
    static StudentResult result = new StudentResult();
    static StudentResult mark = new StudentResult();

    public static void main(String[] args) {
        while (true) {
            studentLogin();
        }
    }

    static void studentPaymentLedger(int id) {

    }

    static void studentResult(int id) {

    }

    static void studentPasswordChange(int id) {

    }

    static void studentProfileUpdate(int id) {

    }

    static void studentProfile(int id) {

    }

    static void studentDashboard(int id) {

    }

    static void studentLogin() {

    }
}


