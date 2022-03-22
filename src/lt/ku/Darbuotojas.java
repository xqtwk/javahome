package lt.ku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Darbuotojas {
    private String vardas;
    private String pavarde;
    private int atlyginimas;
    public static void main(String[] args) {
        Darbuotojas Richard = new Darbuotojas("Lukas", "Simkus", 10000);
        Darbuotojas Lukas = new Darbuotojas("Dovydas", "Juodas", 5555);
        Darbuotojas Trecias = new Darbuotojas("Trecias", "Darbuotojas", 6321);
        Darbuotojas[] Darbuotojai = {Richard, Lukas, Trecias};

        for (Darbuotojas current : Darbuotojai) {
             System.out.println(current.getName() + " " + current.getSurname() + " " + current.getWage());
        }
        System.out.println("Vidutinis darbo uzmokestis:" + averageWage(Darbuotojai));
        printInfo(Darbuotojai);
        readFile();
    }

    public Darbuotojas(){

    }

    public Darbuotojas(String name, String surname, int wage){
        vardas = name; pavarde = surname; atlyginimas = wage;
    }

    public String getName() {
        return this.vardas;
    }

    public String getSurname() {
        return this.pavarde;
    }

    public int getWage() {
        return this.atlyginimas;
    }

    public static int averageWage(Darbuotojas[] p){
        int result = 0;
        for (Darbuotojas current : p) {
            result += current.getWage();
        }
        return result;
    }
    public double incomeTax(){
        double tax = this.getWage() * 0.15;
        return tax;
    }
    public double sodra(){
        double sodra = this.getWage() * 0.09;
        return sodra;
    }
    public static void printInfo(Darbuotojas[] p){
        double sodra =0;
        double tax = 0;
        int totalWage = 0;
        for (Darbuotojas current : p) {
            sodra += current.sodra();
            tax += current.incomeTax();
            totalWage += current.getWage();
        }
        System.out.println("Viso imoneje darbuotoju: " + p.length);
        System.out.println("Įmonė sumoka darbo užmokesčiui: " + sodra);
        System.out.println("Sumokėtas pajamų mokestis:" + tax);
        System.out.println("Sumokėtas sodros mokestis: " + totalWage);
    }
    public static void readFile(){
        try {
            File file = new File("src/lt/ku/Darbuotojai.txt");
            Scanner finput = new Scanner(file);
            int m = finput.nextInt();
            String[] Workers = new String[m];
            for (int row = 0; row < m; row++) {
                Workers[row] = finput.nextLine();
            }
            for (int row = 0; row < m; row++) {
                System.out.println(Workers[row]);
            }
        }catch (FileNotFoundException e) {
            System.out.println("Ivyko klaida.");
        }
    }
}
