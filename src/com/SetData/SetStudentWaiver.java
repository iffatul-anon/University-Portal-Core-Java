package com.SetData;

import java.io.BufferedWriter;
import  java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SetStudentWaiver {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        File file = new File("Result.csv");

        System.out.print("Enter your username: ");
        String username = scan.nextLine();
        System.out.print("Enter your waiver: ");
        double waiver = scan.nextDouble();
        System.out.print("Required SGPA: ");
        double requiredSGPA = scan.nextDouble();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(username + "," + waiver + "," + requiredSGPA + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}