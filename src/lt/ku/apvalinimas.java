package lt.ku;

import java.io.*;
import java.util.Scanner;
import java.math.*;
public class apvalinimas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Iveskite skaiciu: ");
        double skaicius = input.nextDouble();
        System.out.println("Iki kiek apvalinti?(1 - 0.* ; 2 - 0.0* ir t.t) - VESTI NAUDOJANT KABLELI : ");
        int iki = input.nextInt();
        System.out.println(round(skaicius, iki)); //34.778

    }
    public static double round(double x, int y){
        double scale = Math.pow(10, y);
        double result = Math.ceil(x * scale) / scale;
        return result;
    }
}
