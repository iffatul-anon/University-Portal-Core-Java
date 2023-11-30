package com.Portal;
import java.io.*;
import java.util.Scanner;

public class FacultyPortal {
    static void facultyDashboard(String userID) throws IOException {
        while (true) {
            Main.clearScreen();
            System.out.println("\n\n|| Faculty Portal ||\n");
            System.out.println("ID: " + userID + "\n");
            System.out.println("1. Profile");
            System.out.println("2. Profile Update");
            System.out.println("3. Password Change");
            System.out.println("4. Courses:");
            System.out.println("5. Logout\n");
            System.out.print("Select an option: ");

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();

            if (option == 1) {
                Profile.profile("Faculty",userID);
            } else if (option == 2) {
                Profile.update("Faculty",userID);
            } else if (option == 3) {
                PasswordUpdate.change("Faculty",userID);
            } else if (option == 4) {
                Courses.courses(userID);
            } else if (option == 5) {
                return;
            }
        }
    }
}
