package com.company;

import java.util.Scanner;

public class NextDate {
    public static void main(String[] args) {

        Scanner dateInput = new Scanner(System.in);

        int day = dateInput.nextInt();
        int month = dateInput.nextInt();
        int year = dateInput.nextInt();

        System.out.println("Enter any date to get the next day. (Only valid years: 1812 - 2212)");
        System.out.println("Please enter in format dd mm yy: ");

        System.out.println("The next date is: " + NextDate(day, month, year));
    }

    public static String NextDate(int day, int month, int year) {
        int newDay = day;
        int newMonth = month;
        int newYear = year;

        boolean error = false;
        boolean isLeapYear = false;

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            isLeapYear = true;

        // if day given is 30 and month is one of the months that have 30 days
        // set next date as the first of the next month
        if (day == 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            newDay = 1;
            newMonth += 1;
        }

        // if day given is 31 and month is one of the months that have 30 days
        // then return error
        else if (day == 31 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            error = true;
            System.out.println("Invalid date");
            return "Invalid date";
        }


        // if day given is 31 and month is one of the months that have 31 days
        // set next date as the first of the next month
        else if (day == 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
                || month == 10)) {
            newDay = 1;
            newMonth += 1;
        }

        // if day given is 28, month is february, and it is a leap year
        // increment the day to 29
        else if (day == 28 && month == 2 && isLeapYear )
            newDay += 1;


        // if day given is 28 and month is february, but it is not a leap year
        // set next date as the first of the next month
        else if (day == 28 && month == 2 && !isLeapYear ) {
            newDay = 1;
            newMonth += 1;
        }

        // if day given is 29, month is february, and it is leap year
        // set next date as the first of the next month
        else if (day == 29 && month == 2 && isLeapYear) {
            newDay = 1;
            newMonth += 1;
        }

        // if day is 29, month is february, and it is not a leap year
        //print error
        else if (day == 29 && month == 2 && !isLeapYear) {
            error = true;
            System.out.println("Invalid date");
            return "Invalid date";
        }

        //if an invalid year is inputted, print error
        else if (year < 1812 || year > 2212) {
            error = true;
            System.out.println("Cannot process dates before 1812 and after 2212");
            return "Cannot process dates before 1812 and after 2212";
        }

        //if month is february but day is 30 or 31
        //then print error
        else if ((day == 30 || day == 31) && month == 2) {
            error = true;
            System.out.println("Invalid date");
            return "Invalid date";
        }

        //if month is december and day is 31 but the next year is out of bounds(2213),
        //then print error
        else if (month == 12 && day == 31 && (year + 1 == 2213)) {
            error = true;
            System.out.println("Invalid date");
            return "Invalid date";
        }

        //if month is december and day is 31, set date as first day of first month of next year
        else if (month == 12 && day == 31) {
            newYear += 1;
            newDay = 1;
            newMonth = 1;
        }

        //if day is greater than 31 or day is less than 1, print error
        else if (day > 31 || day < 1) {
            error = true;
            System.out.println("Invalid date");
            return "Invalid date";

        }

        //if month given is greater than 12 or less than 1, print error
        else if (month > 12 || month < 1) {
            error = true;
            System.out.println("Invalid date");
            return "Invalid date";
        }

        // increment date to the next day
        else
            newDay += 1;


        //if error is false, print out date of next day
        if (!error)
            System.out.println(newDay + " " + newMonth + " " + newYear);

        return (newDay + " " + newMonth + " " + newYear);
    }
}
