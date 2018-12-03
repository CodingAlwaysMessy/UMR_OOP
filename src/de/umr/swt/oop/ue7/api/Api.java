package de.umr.swt.oop.ue7.api;

import java.util.Calendar;

public class Api { //blöder Name, aber war ja nichts weiter angegeben

    public static String tossCoin() {
        if ((((int) (java.lang.Math.random() * 10) & 1) == 1)) { // using the first figure of the random number to decide if even or odd (0-9)
            return "Kopf";
        } else {
            return "Zahl";
        }
    }

    public static int getTimeDifference(Calendar a, Calendar b) {

        // get current time of both instances in ms
        double end = b.getTimeInMillis();
        double start = a.getTimeInMillis();

        double dif = Math.abs(end - start); // building difference (unsigned)

        dif = dif / 1000 / 60 / 60; // converting to hours

        return (int) dif;
    }

    public static int emi(double interest, int payments, int loan) {

        // breaking the formula apart for readability
        double numerator = interest * Math.pow((1 + interest), payments);
        double denominator = Math.pow(1 + interest, payments) - 1;

        double rate = loan * (numerator / denominator);

        return (int) rate / 100;
    }


}
