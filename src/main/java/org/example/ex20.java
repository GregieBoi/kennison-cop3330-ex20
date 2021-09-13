/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 McGreggor Kennison
 */

package org.example;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ex20 {

    // main
    public static void main(String[] args) {

        // initialize amount
        double amount = get_amount();

        // initialize tax and calculate total
        double tax = get_tax(amount, get_state());
        double total = amount + tax;

        // set format and rounding mode
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.CEILING);

        // print output
        System.out.println("The tax is $" + df.format(tax) + ".\n"
                + "The total is $" + df.format(total) + ".");

    }

    // gets amount
    public static double get_amount() {

        // prompts for input and returns scan
        System.out.print("What is the order amount? ");
        Scanner input = new Scanner(System.in);
        return input.nextDouble();
    }

    // gets state
    public static String get_state() {

        // prompts for input and returns scan
        System.out.print("What is the state? ");
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    // determines county in WI and returns tax rate of that county
    public static double if_WI(double amount) {

        // prompts for input and stores into county
        System.out.print("What county do you live in? ");
        Scanner input = new Scanner(System.in);
        String county = input.nextLine();

        // passes to get_tax_rate for return value
        return get_tax_rate(county);

    }

    // checks county and returns proper rate for county
    public static double get_tax_rate(String county) {

        // if else to determine tax rate for county
        if (county.equals("Eau Claire"))
            // return EC rate
            return .06;
        else if (county.equals("Dunn"))
            // return dunn rate
            return .059;
        else
            // return normal rate for all other
            return .055;

    }

    // calculates and returns tax
    public static double get_tax(double amount, String state) {

        // initialize rate
        double tax_rate = 0;

        // if else to determine if WI or IL
        if (state.equals("WI")) {

            // pass to if_WI to figure county tax
            tax_rate = if_WI(amount);

        }
        else if (state.equals("IL")) {

            // set rate to IL rate
            tax_rate = 0.08;

        }

        // return calculate tax
        return  (amount * tax_rate);
    }

}
