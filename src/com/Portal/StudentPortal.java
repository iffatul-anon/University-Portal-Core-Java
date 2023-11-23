package com.Portal;

import java.io.*;
import java.util.Scanner;


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

public class StudentPortal {

    static void studentDashboard(String userID) throws IOException {
        while (true) {
            Main.clearScreen();
            System.out.println("\n\n|| Student Portal ||\n\n\n");
            System.out.println("ID : " + userID + "\n\n");
            System.out.println("1. Profile");
            System.out.println("2. Profile Update");
            System.out.println("3. Password Change");
            System.out.println("4. Result");
            System.out.println("5. Payment Ledger");
            System.out.println("6. Logout\n\n");
            System.out.print("Select an option: ");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            if (option == 1) {
                Profile.profile("Student",userID);
            } else if (option == 2) {
                Profile.update("Student",userID);
            } else if (option == 3) {
                PasswordUpdate.change("Student",userID);
            } else if (option == 4) {
                result();
            } else if (option == 5) {
                paymentLedger();
            } else if (option == 6) {
                return;
            }
        }
    }
    static void result(){

    }
    static void paymentLedger(){

    }
}

