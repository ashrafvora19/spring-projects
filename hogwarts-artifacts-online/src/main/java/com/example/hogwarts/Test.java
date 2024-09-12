package com.example.hogwarts;

public class Test {

	public static double roundToNearestHalf(double value) {
        return Math.round(value * 2) / 2.0;
    }

    public static void main(String[] args) {
        double num = 4.53;
        double roundedValue = roundToNearestHalf(num);
        System.out.println("Original: " + num);
        System.out.println("Rounded: " + roundedValue);
    }
}
