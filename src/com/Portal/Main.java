package com.Portal;
import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            clearScreen();

            System.out.println("\n\n|| Welcome to DIU Portal ||\n\n");
            System.out.println("   1. Faculty Login");
            System.out.println("   2. Student Login");
            System.out.println("   3. Exit\n");
            System.out.print("   Select an option: ");

            int option = scanner.nextInt();

            if(option==1) {
                Login.login("Faculty");
            }
            else if(option==2) {
                Login.login("Student");
            }
            else if(option==3) {
                clearScreen();
                System.out.println("\n\nThank You\n\n\n");
                return;
            }
            else System.out.println("Invalid option. Please try again.");
        }
    }

    static void clearScreen() throws IOException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            // For Windows
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            // For Unix-like systems (Linux, macOS)
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } else {
            // Unsupported or unknown operating system
            System.out.println("Clear screen not supported on this operating system.");
        }
    }
}
