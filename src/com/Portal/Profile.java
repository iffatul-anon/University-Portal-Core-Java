package com.Portal;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
        System.out.println("\n\n||" + userType + " Portal ||\n\n");
        System.out.println("\n\n|| Profile ||\n\n\n");

        ArrayList<Profile> users = new ArrayList<>();

        boolean flag=true;

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(userType + "Information.csv"));
            {
                String data = br.readLine();
                while (data != null) {
                    String[] datapart= data.split(",");
                    Profile user = new Profile(datapart[0],datapart[1],datapart[2],datapart[3],datapart[4],datapart[5],datapart[6], datapart[7],datapart[8],datapart[9]);
                    users.add(user);
                    data = br.readLine();
                }
            }
            for (Profile user : users) {
                if (user.username.equals(username)) {
                    System.out.println("ID:" + user.username);
                    System.out.println("\nName:" + user.name);
                    System.out.println("\nDepartment:" + user.department);
                    System.out.println("\nDateOfBirth:" + user.dateOfBirth);
                    System.out.println("\nFather Name:" + user.fatherName);
                    System.out.println("\nMother Name:" + user.motherName);
                    System.out.println("\nBlood Group:" + user.bloodGroup);
                    System.out.println("\nPhone:" + user.phone);
                    System.out.println("\nE-mail:" + user.email);
                    System.out.println("\nAddress:" + user.address);
                    flag=false;
                    break;
                }
            }
            if(flag) {
                System.out.println("Please Update Your Profile");
            }
            System.out.print("\n\nPress Enter to continue...");
            new Scanner(System.in).nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        br.close();
    }

    static void update(String userType, String userID) throws IOException {
        Main.clearScreen();
        System.out.println("\n\n||" + userType + " Portal ||\n\n");
        System.out.println("|| Profile Update ||\n\n\n");

        Scanner scan = new Scanner(System.in);
        ArrayList<Profile> users = new ArrayList<>();

        boolean flag=true;

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(userType + "Information.csv"));
            {
                String data = br.readLine();
                while (data != null) {
                    String[] datapart= data.split(",");
                    Profile user = new Profile(datapart[0],datapart[1],datapart[2],datapart[3],datapart[4],datapart[5],datapart[6], datapart[7],datapart[8],datapart[9]);
                    users.add(user);
                    data = br.readLine();
                }
            }
            for (Profile user : users) {
                if (user.username.equals(userID)) {
                    while(true) {
                        System.out.println("\nWhich option would you like to edit?");
                        System.out.println("\n1. Name:" + user.name);
                        System.out.println("\n2. DateOfBirth:" + user.dateOfBirth);
                        System.out.println("\n3. Father Name:" + user.fatherName);
                        System.out.println("\n4. Mother Name:" + user.motherName);
                        System.out.println("\n5. Blood Group:" + user.bloodGroup);
                        System.out.println("\n6. Phone:" + user.phone);
                        System.out.println("\n7. E-mail:" + user.email);
                        System.out.println("\n8. Address:" + user.address);
                        System.out.println("\n9. Back:");

                        System.out.print("\nEnter: ");
                        int option = scan.nextInt();

                        if (option == 9) {
                            break;
                        }

                        if(option==1){
                            System.out.print("\nName:");
                            user.name = scan.nextLine();
                        }
                        if(option==2){
                            System.out.print("\nDateOfBirth:");
                            user.dateOfBirth = scan.nextLine();
                        }
                        if(option==3){
                            System.out.print("\nFather Name:");
                            user.fatherName = scan.nextLine();
                        }
                        if(option==4){
                            System.out.print("\nMother Name:");
                            user.motherName = scan.nextLine();
                        }
                        if(option==5){
                            System.out.print("\nBlood Group:");
                            user.bloodGroup = scan.nextLine();
                        }
                        if(option==6){
                            System.out.print("\nPhone:");
                            user.phone = scan.nextLine();
                        }
                        if(option==7){
                            System.out.print("\nE-mail:");
                            user.email = scan.nextLine();
                        }
                        if(option==8){
                            System.out.print("\nAddress:");
                            user.address = scan.nextLine();
                        }
                    }
                    flag=false;
                    for(Profile user2 : users){

                        File file = new File(userType +"Information.csv");
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                        writer.write(userID + "," + user2.name + "," + user2.department + "," + user2.dateOfBirth + "," + user2.fatherName + "," + user2.motherName + "," + user2.bloodGroup + "," + user2.phone + "," + user2.email + "," + user2.address + "\n");
                        writer.close();
                    }
                    break;
                }
            }
            if(flag) {
                Profile user = new Profile();
                System.out.println("Please Complete Your Profile First");
                System.out.println("\nID:" + userID);
                System.out.print("\nName:");
                user.name = scan.nextLine();
                System.out.print("\nDepartment:");
                user.department = scan.nextLine();
                System.out.print("\nDateOfBirth:");
                user.dateOfBirth = scan.nextLine();
                System.out.print("\nFather Name:");
                user.fatherName = scan.nextLine();
                System.out.print("\nMother Name:");
                user.motherName = scan.nextLine();
                System.out.print("\nBlood Group:");
                user.bloodGroup = scan.nextLine();
                System.out.print("\nPhone:");
                user.phone = scan.nextLine();
                System.out.print("\nE-mail:");
                user.email = scan.nextLine();
                System.out.print("\nAddress:");
                user.address = scan.nextLine();

                File file = new File(userType +"Information.csv");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                writer.write(userID + "," + user.name + "," + user.department + "," + user.dateOfBirth + "," + user.fatherName + "," + user.motherName + "," + user.bloodGroup + "," + user.phone + "," + user.email + "," + user.address + "\n");
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        br.close();

        System.out.println("\n----- " + userType + "( ID #" + userID + ") Profile was Updated -----");
    }
}
