package com.Portal;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordUpdate {

    String username;
    String password;
    PasswordUpdate(String username,String password){
        this.username = username;
        this.password = password;
    }

    static void change(String userType, String userID) throws IOException {
        Main.clearScreen();
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n||" + userType + " Portal ||\n");
        System.out.println("|| Password Update ||\n\n");
        System.out.print("Enter Your Password: ");
        String input = scan.next();
        boolean flag = true;

        ArrayList<PasswordUpdate> users = new ArrayList<>();
        File file = new File(userType + "Password.csv");

        BufferedReader br = new BufferedReader(new FileReader(file));
        {
            String data = br.readLine();
            while (data != null) {
                String[] datapart = data.split(",");
                if(datapart.length>=2) {
                    PasswordUpdate user = new PasswordUpdate(datapart[0], datapart[1]);
                    users.add(user);
                }
                data = br.readLine();
            }
        }
        br.close();
        for (PasswordUpdate user : users) {
            if (user.username.equals(userID) && user.password.equals(input)) {
                while (true) {
                    System.out.print("Enter New Password:");
                    String input2 = scan.next();
                    System.out.print("Confirm Password:");
                    String input3 = scan.next();

                    if (input2.equals(input3)) {
                        System.out.println("Password Update Successful");
                        user.password = input3;
                        break;
                    }
                    System.out.println("New Password & Confirm Password Didn't Match");
                }
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                for (PasswordUpdate user2 : users) {
                    writer.write(user2.username + "," + user2.password + "\n");
                }
                writer.close();
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Wrong Password");
        }
        System.out.print("\n\nPress Enter to continue...");
        new Scanner(System.in).nextLine();
    }
}
