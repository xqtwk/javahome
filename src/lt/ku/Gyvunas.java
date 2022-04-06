package lt.ku;
import java.util.*;
import java.util.Collections;
import java.lang.Comparable;
import java.util.Scanner;
class Zuvis extends Gyvunas{
    private int pelekuKiekis;
    public Zuvis(String a){
        this.setName(a);
        this.setType(this.getClass().getSimpleName());
    }
    public void setPelekuKiekis(int t){
        this.pelekuKiekis = t;
    }
    public int getPelekuKiekis(){
        return this.pelekuKiekis;
    }

    @Override
    void to_String() {
        super.to_String();
        if (getType() != null){ System.out.print(", " + "Tipas:" + getType()); }
        if (getPelekuKiekis() != 0){System.out.print(", " + "Peleku kaicius: " + getPelekuKiekis()); }
        System.out.println();
    }

    @Override
    public int compareTo(Gyvunas T) {
        int i = this.getType().compareTo(T.getType());
        if(i != 0) return i;

        i = this.getName().compareTo(T.getName());
        if (i != 0) return i;

        return i;
    }
}

class Ziurkenas extends Gyvunas{
    private int uodegosilgis;
    private String spalva;

    public Ziurkenas(String a){
        this.setName(a);
        this.setType(this.getClass().getSimpleName());
    }
    public void setColour(String n){
        this.spalva = n;
    }
    public void setTailLength(int t){
        this.uodegosilgis = t;
    }
    public String getColour(){
        return this.spalva;
    }
    public int getTailLength(){
        return this.uodegosilgis;
    }

    @Override
    void to_String() {
        super.to_String();
        if (getType() != null){ System.out.print(", " + "Tipas:" + getType()); }
        if (getTailLength() != 0){ System.out.print(", " + "Uodegos Ilgis:" + getTailLength()); }
        if (getColour() != null){ System.out.print(", " + "Spalva: " + getColour()); }
        System.out.println();
    }
    @Override
    public int compareTo(Gyvunas T) {
        int i = this.getType().compareTo(T.getType());
        if(i != 0){ return i;}
        i = this.getName().compareTo(T.getName());
        if (i != 0){ return i;}

        return i;
    }
}
public abstract class Gyvunas implements Comparable<Gyvunas>{
    String name, type;
    static LinkedList <Gyvunas> gyvunai = new LinkedList<Gyvunas>();
    public static void main(String[] args) {
    Ziurkenas a = new Ziurkenas("Vacis");
    Zuvis b = new Zuvis("morta");
    Zuvis z = new Zuvis("Vacis");
    b.setPelekuKiekis(10);
    a.setColour("Juodas");
    a.setTailLength(2);
    //b.to_String();
    //a.to_String();
    //b.to_String();
    gyvunai.add(z);
    gyvunai.add(a);
    gyvunai.add(b);
    Collections.sort(gyvunai);
    search("Vacis");
    }
    public Gyvunas(){ }
    public Gyvunas(String a, String b){
        this.name = a; this.type = b;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setType(String t){
        this.type = t;
    }
    public String getName(){
        return this.name;
    }
    public String getType(){
        return this.type;
    }
    void to_String(){
        System.out.print("Vardas: " + getName());
    }
    static void search(String n){
        for (Gyvunas animal: gyvunai){
            if(animal.getName() == n){
                animal.to_String();
            }
        }
    }
}

