package com.SetData;

import java.io.BufferedWriter;
import  java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SetFacultyPassword {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        File file = new File("FacultyPassword.csv");

        System.out.print("Enter your username: ");
        String username = scan.nextLine();
        System.out.print("Enter your password: ");
        String password = scan.nextLine();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(username + "," + password + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}