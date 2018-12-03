package de.umr.swt.oop.ue7.graycode;

public class Main {

    public static void main(String[] args) {

        GrayCode gc = new GrayCode(4);
        gc.print();

        gc.findCode("1010");

    }
}
