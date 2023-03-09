package com.company;

public class NextDate {
    public static void main(String[] args) {

        NextDate(30,12,2212);
    }

    public static String NextDate(int day, int month, int year) {

        int receivedDay = day;
        int receivedMonth = month;
        int receivedYear = year;

        boolean error = false;
        boolean isLeapYear = false;

        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            isLeapYear = true;



        // if date given is 30 and month is ___________
        if (day == 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            receivedDay = 1;
            receivedMonth += 1;
        }

        else if (day == 31 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            error = true;
            System.out.println("Invalid date");
            return "Invalid date";
        }


        // if date given is 31 and month is ___________
        else if (day == 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
                || month == 10)) {
            receivedDay = 1;
            receivedMonth += 1;
        }

        // if date given is 28 and month is february and it is a leap year
        else if (day == 28 && month == 2 && isLeapYear )
            receivedDay += 1;


            // if date given is 28 and month is february and it is not a leap year
        else if (day == 28 && month == 2 && !isLeapYear ) {
            receivedDay = 1;
            receivedMonth += 1;
        }

        // if date given is between 29 and month is february, and it is leap year
        else if (day == 29 && month == 2 && isLeapYear) {
            receivedDay = 1;
            receivedMonth += 1;
        }

        else if (year < 1812 || year > 2212) {
            error = true;
            System.out.println("Cannot process dates before 1812 and after 2212");
            return "Cannot process dates before 1812 and after 2212";
        }

        // if date given is between 29 and month is february, and it is not a leap year
        else if (day == 29 && month == 2 && !isLeapYear) {
            error = true;
            System.out.println("Invalid date");
            return "Invalid date";
        }

        else if ((day == 30 || day == 31) && month == 2) {
            error = true;
            System.out.println("Invalid date");
            return "Invalid date";
        }

        else if (month == 12 && day == 31 && (year + 1 == 2213)) {
            error = true;
            System.out.println("Invalid date");
            return "Invalid date";
        }

        else if (month == 12 && day == 31) {
            receivedYear += 1;
            receivedDay = 1;
            receivedMonth = 1;
        }

        else if (day >= 32) {
            error = true;
            System.out.println("Invalid date");
            return "Invalid date";

        }

        else
            receivedDay += 1;


        if (!error)
            System.out.println(receivedDay + " " + receivedMonth + " " + receivedYear);

        return (receivedDay + " " + receivedMonth + " " + receivedYear);
    }
}
