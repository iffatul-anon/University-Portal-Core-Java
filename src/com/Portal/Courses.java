package com.Portal;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Courses {
    String userID;
    String course1;
    String course2;
    String course3;
    String course4;
    Courses(String userID,String course1,String course2,String course3,String course4){
        this.userID=userID;
        this.course1=course1;
        this.course2=course2;
        this.course3=course3;
        this.course4=course4;
    }
    static void courses(String userID) throws IOException {
        Main.clearScreen();
        int course = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\n|| Faculty Portal ||\n");
        System.out.println("|| Courses ||\n");

        if (userID.equals("1001")) {
            System.out.println("ID: 1001");
            System.out.println("\n1. Object Oriented Design");
            System.out.println("2. Object Oriented Lab");
            System.out.print("Select:");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            if (option == 1) {
                course = 1;
            } else if (option == 2) {
                course = 2;
            }
        }
        if (userID.equals("1002")) {
            System.out.println("ID: 1002");
            System.out.println("\n1. Object Oriented Design");
            System.out.println("2. Object Oriented Lab");
            System.out.print("Select:");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            if (option == 1) {
                course = 3;
            } else if (option == 2) {
                course = 4;
            }
        }

        ArrayList<Courses> users = new ArrayList<>();
        File file = new File("Result.csv");

        BufferedReader br = new BufferedReader(new FileReader(file));
        {
            String data = br.readLine();
            while (data != null) {
                String[] datapart = data.split(",");
                if(datapart.length>=5) {
                    Courses user = new Courses(datapart[0], datapart[1], datapart[2], datapart[3], datapart[4]);
                    users.add(user);
                }
                data = br.readLine();
            }
        }
        br.close();
        while (true) {
            System.out.println("ID\tPoint");
            int c = 0;
            for (Courses user : users) {
                c++;
                if (c > 1) {
                    if (course == 1) {
                        System.out.println(user.userID + "\t" + user.course1);
                    } else if (course == 2) {
                        System.out.println(user.userID + "\t" + user.course2);
                    } else if (course == 3) {
                        System.out.println(user.userID + "\t" + user.course3);
                    } else if (course == 4) {
                        System.out.println(user.userID + "\t" + user.course4);
                    }
                }
            }
            System.out.println("\n1. Entry:");
            System.out.println("2. Back:");
            System.out.print("Select:");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            if (option == 2) {
                break;
            }
            System.out.print("\nID:");
            String input = scan.nextLine();
            for (Courses user : users) {
                if (user.userID.equals(input)) {
                    System.out.print("Enter Marks:");
                    if (course == 1) {
                        user.course1 = Grade.gradePoint(scan.nextDouble());
                    } else if (course == 2) {
                        user.course2 = Grade.gradePoint(scan.nextDouble());
                    } else if (course == 3) {
                        user.course3 = Grade.gradePoint(scan.nextDouble());
                    } else if (course == 4) {
                        user.course4 = Grade.gradePoint(scan.nextDouble());
                    }
                    break;
                }
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (Courses user : users) {
                writer.write(user.userID + "," + user.course1 + "," + user.course2 + "," + user.course3 + "," + user.course4 + "\n");
            }
            writer.close();
        }
    }
}
