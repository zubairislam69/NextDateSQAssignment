package com.company;

import org.junit.Test;

import static org.junit.Assert.*;

public class NextDateTest {

    @Test
    public void invalidDay() {
        assertEquals(NextDate.NextDate(31, 12, 2212), "Invalid date");
        assertEquals(NextDate.NextDate(31, 4, 1913), "Invalid date");
        assertEquals(NextDate.NextDate(32, 5, 1999), "Invalid date");
        assertEquals(NextDate.NextDate(0, 5, 1999), "Invalid date");

    }

    @Test
    public void invalidMonth() {
        assertEquals(NextDate.NextDate(4, 20, 1999), "Invalid date");
        assertEquals(NextDate.NextDate(10, 13, 2024), "Invalid date");
        assertEquals(NextDate.NextDate(10, 0, 2024), "Invalid date");
    }

    @Test
    public void invalidYear() {
        assertEquals(NextDate.NextDate(4, 7, 1811), "Cannot process dates before 1812 and after 2212");
        assertEquals(NextDate.NextDate(4, 7, 3000), "Cannot process dates before 1812 and after 2212");

    }

    @Test
    public void leapYear() {
        assertEquals(NextDate.NextDate(28, 2, 1812), "29 2 1812");
        assertEquals(NextDate.NextDate(29, 2, 1816), "1 3 1816");
    }

    @Test
    public void nonLeapYear() {
        assertEquals(NextDate.NextDate(28, 2, 2011), "1 3 2011");
        assertEquals(NextDate.NextDate(29, 2, 2011), "Invalid date");
    }

    @Test
    public void nextDay() {
        assertEquals(NextDate.NextDate(1, 12, 2212), "2 12 2212");
        assertEquals(NextDate.NextDate(30, 4, 1913), "1 5 1913");
        assertEquals(NextDate.NextDate(31, 12, 2022), "1 1 2023");

    }

    @Test
    public void nextYear() {
        assertEquals(NextDate.NextDate(31, 12, 2022), "1 1 2023");
        assertEquals(NextDate.NextDate(31, 12, 1900), "1 1 1901");
    }

}