package com.Portal;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Profile {

    String username;
    String name;
    String department;
    String dateOfBirth;
    String fatherName;
    String motherName;
    String bloodGroup;
    String email;
    String phone;
    String address;
    Profile(){

    }
    Profile(String username,String name,String department,String dateOfBirth,String fatherName,String motherName,String bloodGroup,String phone,String email,String address){
        this.username = username;
        this.name = name;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.bloodGroup = bloodGroup;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    static void profile(String userType , String username) throws IOException {
        Main.clearScreen();
        System.out.println("\n\n||" + userType + " Portal ||\n");
        System.out.println("|| Profile ||\n");

        ArrayList<Profile> users = new ArrayList<>();
        File file = new File(userType + "Information.csv");

        boolean flag = true;

        BufferedReader br = new BufferedReader(new FileReader(file));
        {
            String data = br.readLine();
            while (data != null) {
                String[] datapart = data.split(",");
                if(datapart.length>=10) {
                    Profile user = new Profile(datapart[0], datapart[1], datapart[2], datapart[3], datapart[4], datapart[5], datapart[6], datapart[7], datapart[8], datapart[9]);
                    users.add(user);
                }
                data = br.readLine();
            }
        }
        br.close();
        for (Profile user : users) {
            if (user.username.equals(username)) {
                System.out.println("ID:" + user.username);
                System.out.println("Name:" + user.name);
                System.out.println("Department:" + user.department);
                System.out.println("DateOfBirth:" + user.dateOfBirth);
                System.out.println("Father Name:" + user.fatherName);
                System.out.println("Mother Name:" + user.motherName);
                System.out.println("Blood Group:" + user.bloodGroup);
                System.out.println("Phone:" + user.phone);
                System.out.println("E-mail:" + user.email);
                System.out.println("Address:" + user.address);
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Please Update Your Profile");
        }
        System.out.print("\nPress Enter to continue...");
        new Scanner(System.in).nextLine();
    }

    static void update(String userType, String userID) throws IOException {
        Main.clearScreen();
        System.out.println("\n\n||" + userType + " Portal ||\n");
        System.out.println("|| Profile Update ||\n");

        Scanner scan = new Scanner(System.in);
        ArrayList<Profile> users = new ArrayList<>();
        File file = new File(userType + "Information.csv");

        boolean flag = true;

        BufferedReader br = new BufferedReader(new FileReader(file));
        {
            String data = br.readLine();
            while (data != null) {
                String[] datapart = data.split(",");
                if(datapart.length>=10) {
                    Profile user = new Profile(datapart[0], datapart[1], datapart[2], datapart[3], datapart[4], datapart[5], datapart[6], datapart[7], datapart[8], datapart[9]);
                    users.add(user);
                }
                data = br.readLine();
            }
        }
        br.close();
        for (Profile user : users) {
            if (user.username.equals(userID)) {
                while (true) {
                    System.out.println("Which option would you like to edit?");
                    System.out.println("1. Name:" + user.name);
                    System.out.println("2. DateOfBirth:" + user.dateOfBirth);
                    System.out.println("3. Father Name:" + user.fatherName);
                    System.out.println("4. Mother Name:" + user.motherName);
                    System.out.println("5. Blood Group:" + user.bloodGroup);
                    System.out.println("6. Phone:" + user.phone);
                    System.out.println("7. E-mail:" + user.email);
                    System.out.println("8. Address:" + user.address);
                    System.out.println("9. Back:");

                    System.out.print("\nEnter: ");
                    int option = scan.nextInt();

                    Scanner scanner = new Scanner(System.in);

                    if (option == 9) {
                        break;
                    }

                    if (option == 1) {
                        System.out.print("\nName:");
                        user.name = scanner.nextLine();
                    }
                    if (option == 2) {
                        System.out.print("\nDateOfBirth:");
                        user.dateOfBirth = scanner.nextLine();
                    }
                    if (option == 3) {
                        System.out.print("\nFather Name:");
                        user.fatherName = scanner.nextLine();
                    }
                    if (option == 4) {
                        System.out.print("\nMother Name:");
                        user.motherName = scanner.nextLine();
                    }
                    if (option == 5) {
                        System.out.print("\nBlood Group:");
                        user.bloodGroup = scanner.nextLine();
                    }
                    if (option == 6) {
                        System.out.print("\nPhone:");
                        user.phone = scanner.nextLine();
                    }
                    if (option == 7) {
                        System.out.print("\nE-mail:");
                        user.email = scanner.nextLine();
                    }
                    if (option == 8) {
                        System.out.print("\nAddress:");
                        user.address = scanner.nextLine();
                    }
                }
                flag = false;
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for (Profile user2 : users) {
                    writer.write(user2.username + "," + user2.name + "," + user2.department + "," + user2.dateOfBirth + "," + user2.fatherName + "," + user2.motherName + "," + user2.bloodGroup + "," + user2.phone + "," + user2.email + "," + user2.address + "\n");
                }
                writer.close();
                break;
            }
        }
        if (flag) {
            Profile user = new Profile();
            System.out.println("Please Complete Your Profile First");
            System.out.println("ID:" + userID);
            System.out.print("Name:");
            user.name = scan.nextLine();
            System.out.print("Department:");
            user.department = scan.nextLine();
            System.out.print("DateOfBirth:");
            user.dateOfBirth = scan.nextLine();
            System.out.print("Father Name:");
            user.fatherName = scan.nextLine();
            System.out.print("Mother Name:");
            user.motherName = scan.nextLine();
            System.out.print("Blood Group:");
            user.bloodGroup = scan.nextLine();
            System.out.print("Phone:");
            user.phone = scan.nextLine();
            System.out.print("E-mail:");
            user.email = scan.nextLine();
            System.out.print("Address:");
            user.address = scan.nextLine();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(userID + "," + user.name + "," + user.department + "," + user.dateOfBirth + "," + user.fatherName + "," + user.motherName + "," + user.bloodGroup + "," + user.phone + "," + user.email + "," + user.address + "\n");
            writer.close();
        }
    }
}
