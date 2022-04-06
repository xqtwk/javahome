package lt.ku;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Imone {
    private String pavadinimas;
    private String imones_kodas;
    private ArrayList<Darbuotojas> darbuotojai = new ArrayList();
    public static void main(String[] args) {
        Imone dmx = new Imone("dmx","1B");
        dmx.to_String();
        System.out.println("q) prideti darbuotoja");
        System.out.println("w) pasalinti darbuotoja");
        System.out.println("e) keisti imones pavadinima");
        System.out.println("r) keisti imones koda");
        System.out.println("Q) Baigti");
        String options = null;
        Scanner scan = new Scanner(System.in);
        do {
            options = scan.nextLine();
            switch (options) {
                case "q":
                    System.out.println("Iveskite darbuotojo duomenis(vardas,pavarde,atlyginimas)");
                    String vardas = scan.nextLine();
                    String pavarde = scan.nextLine();
                    int alga = scan.nextInt();
                    Darbuotojas worker = new Darbuotojas(vardas,pavarde,alga);
                    dmx.prideti(worker);
                    System.out.println("Darbuotojas pridetas");
                    dmx.to_String();
                    break;
                case "w":
                    System.out.println("Iveskite darbuotojo id");
                    int id = scan.nextInt();
                    dmx.pasalinti(id);
                    System.out.println("Darbuotojas pasalintas");
                    dmx.to_String();
                    break;
                case "e":
                    System.out.println("Iveskite nauja pavadinima)");
                    String pavadinimas = scan.nextLine();
                    dmx.set_pavadinimas(pavadinimas);
                    dmx.to_String();
                    break;
                case "r":
                    System.out.println("Iveskite nauja koda)");
                    String kodas = scan.nextLine();
                    dmx.set_Imones_kodas(kodas);
                    dmx.to_String();
                    break;
            }
        } while (!options.equals("Q"));
    }
    public Imone(){

    }

    public Imone(String pav, String imone){
    pavadinimas = pav; imones_kodas = imone;
    }

    public void set_pavadinimas(String pav){
        pavadinimas = pav;
    }

    public void set_Imones_kodas(String imone){
        imones_kodas = imone;
    }

    void prideti(Darbuotojas worker){
        darbuotojai.add(worker);
    }

    void pasalinti(int x){
        darbuotojai.remove(x);
    }

    public ArrayList getWorkers(){
        return darbuotojai;
    }

    public String get_name(){
        return pavadinimas;
    }

    public String get_code(){
        return imones_kodas;
    }
    public void printWorkers(){
        Darbuotojas list;
        for(int i = 0; i < darbuotojai.size(); i++){
            list = darbuotojai.get(i);
            System.out.print("[" + i + ":" + list.getName() + ":" + list.getSurname() + ":" + list.getWage() + "]");
        }
        System.out.println();
    }
    void to_String(){
        System.out.print(get_name() + " " + get_code() + " " );
        this.printWorkers();
    }
}
