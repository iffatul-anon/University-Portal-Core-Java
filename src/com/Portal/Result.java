package com.Portal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Result {
    String userID;
    String course1;
    String course2;
    String course3;
    String course4;
    Result(String userID,String course1,String course2,String course3,String course4){
        this.userID=userID;
        this.course1=course1;
        this.course2=course2;
        this.course3=course3;
        this.course4=course4;
    }
    static void result() throws IOException {
        Main.clearScreen();
        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("\n\n|| Student Portal ||\n");
            System.out.println("1. Result");
            System.out.println("2. Back");
            System.out.print("Select:");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            if (option == 2) {
                break;
            }
            System.out.println("|| Result ||\n");
            ArrayList<Result> users = new ArrayList<>();
            File file = new File("Result.csv");

            BufferedReader br = new BufferedReader(new FileReader(file));
            {
                String data = br.readLine();
                while (data != null) {
                    String[] datapart = data.split(",");
                    if(datapart.length>=5) {
                        Result user = new Result(datapart[0], datapart[1], datapart[2], datapart[3], datapart[4]);
                        users.add(user);
                    }
                    data = br.readLine();
                }
            }
            br.close();
            System.out.print("\nID:");
            String input = scan.nextLine();
            for (Result user : users) {
                if (user.userID.equals(input)) {
                    System.out.println("ID :" + user.userID);
                    System.out.println("Object Oriented Design :" + "\t" + user.course1);
                    System.out.println("Object Oriented Lab :" + "\t\t" + user.course2);
                    System.out.println("Database Management :" + "\t\t" + user.course3);
                    System.out.println("Database Management Lab :" + "\t" + user.course4);
                }
            }
            System.out.print("\nPress Enter to continue...");
            new Scanner(System.in).nextLine();
        }
    }
}
