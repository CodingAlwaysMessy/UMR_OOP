package de.umr.swt.oop.ue7.api;
import de.uni.marburg.oop.notifications.NotificationCenter;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        //tossCoin
        NotificationCenter.showMessage("Aufgabe: tossCoin:", Api.tossCoin());

        //getTimeDifference
        // preparation
        Calendar calendarA = Calendar.getInstance();
        Calendar calendarB = Calendar.getInstance();
        calendarB.add(Calendar.HOUR, 200);

        NotificationCenter.showMessage("Aufgabe: getTimeDifference", String.format("Differenz: %d Stunden",
                Api.getTimeDifference(calendarA, calendarB)));

        //emi
        NotificationCenter.showMessage("Aufgabe: EMI loan", String.format("Amount: %d Cent",
                Api.emi(7,1,10000)));



    }
}