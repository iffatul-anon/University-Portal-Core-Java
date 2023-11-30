package com.Portal;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    String username;
    String password;
    Login(String username,String password){
        this.username = username;
        this.password = password;
    }

    static void login(String usertype) throws IOException {
        Main.clearScreen();
        Scanner scan = new Scanner(System.in);
        ArrayList<Login> users = new ArrayList<>();

        System.out.println("\n\n||" + usertype + "Login ||\n");
        System.out.print("Enter your ID: ");
        String username = scan.nextLine();
        System.out.print("Enter Your Password: ");
        String password = scan.next();
        boolean flag = true;

        BufferedReader br = new BufferedReader(new FileReader(usertype + "Password.csv"));
        {
            String data = br.readLine();
            while (data != null) {
                String[] datapart = data.split(",");
                Login user = new Login(datapart[0], datapart[1]);
                users.add(user);
                data = br.readLine();
            }
        }
        br.close();
        for (Login user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                if (usertype.equals("Student")) StudentPortal.studentDashboard(username);
                if (usertype.equals("Faculty")) FacultyPortal.facultyDashboard(username);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Invalid username or password");
            System.out.print("\n\nPress Enter to continue...");
            new Scanner(System.in).nextLine();
        }
    }
}
