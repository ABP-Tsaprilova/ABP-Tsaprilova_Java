package main;
import java.util.Scanner;
import labs.Lab_1;
import labs.Lab_2;
import labs.Lab_3;



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of lab:");
        int lab = scanner.nextInt();

        switch (lab) {
            case 1:
                Lab_1.lab_1();
                break;
            case 2:
                Lab_2.lab_2();
                break;
            case 3:
                Lab_3.lab_3();
                break;

        }
    }
}