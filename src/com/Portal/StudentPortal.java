package com.Portal;
import java.io.*;
import java.util.Scanner;

public class StudentPortal {
    static void studentDashboard(String userID) throws IOException {
        while (true) {
            Main.clearScreen();
            System.out.println("\n\n|| Student Portal ||\n");
            System.out.println("ID : " + userID + "\n");
            System.out.println("1. Profile");
            System.out.println("2. Profile Update");
            System.out.println("3. Password Change");
            System.out.println("4. Result");
            System.out.println("5. Logout\n\n");
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
                Result.result();
            } else if (option == 5) {
                return;
            }
        }
    }
}
