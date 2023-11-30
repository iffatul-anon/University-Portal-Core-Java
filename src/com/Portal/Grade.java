package com.Portal;
public class Grade {
    static String gradePoint(double total) {
        String gradePoint;

        if (total >= 80) {
            gradePoint = "4.00";
        } else if (total >= 75) {
            gradePoint = "3.75";
        } else if (total >= 70) {
            gradePoint = "3.50";
        } else if (total >= 65) {
            gradePoint = "3.25";
        } else if (total >= 60) {
            gradePoint = "3.00";
        } else if (total >= 55) {
            gradePoint = "2.75";
        } else if (total >= 50) {
            gradePoint = "2.50";
        } else if (total >= 45) {
            gradePoint = "2.25";
        } else if (total >= 40) {
            gradePoint = "2.00";
        } else {
            gradePoint = "0.00";
        }
        return gradePoint;
    }
}
