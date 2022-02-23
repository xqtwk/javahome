package lt.ku;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class mokiniai {
    public static void main(String[] args) {
        int [] startdata = new int [100];
        try {
            File file = new File("src/lt/ku/mokiniai.txt");
            Scanner finput = new Scanner(file);
            /*
            Kaip naudotis:
            mokiniai.txt, m - studentu skaicius(faile pirmas skaicius, pirmoj eilej),
            n - dalyku skaicius, antras skaicius pirmoj eilej. Viskas turi buti teisingai uzpildyta,
            t.y jeigu yra 3 mokiniai ir 3 dalykai, turi buti 3 duomenu eiles ir po 3 skaicius joje -
            kitaip ismeta klaida.
             */
            int m = finput.nextInt();
            int n = finput.nextInt();

            int array[][] = new int[m][n];

            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    array[row][col] = finput.nextInt();

                }
            }
            int v = 1;
            double sum = 0;
            double vidurkiai[][] = new double[m][1];
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {
                    sum+= array[row][col];
                }
                vidurkiai[row][0] = sum/n;
                sum = 0;
            }

            /* isvesti visus pazymiu duomenys
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < n; col++) {

                    System.out.print(array[row][col]);
                }
                System.out.println();

            }
            */
            System.out.println("Studentu vidurkiai:");
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < v; col++) {
                    System.out.print(vidurkiai[row][col] + "\t");
                }

            }

            double bendras_vidurkis = 0 ;
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < v; col++) {
                    sum+= vidurkiai[row][col];
                }
                bendras_vidurkis = sum/m;
            }
            System.out.println("\nBendras vidurkis: " + bendras_vidurkis);

            sum = 0;
            int geriausias = 0 ;
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < v; col++) {
                    if (vidurkiai[row][col] > sum){
                        sum = vidurkiai[row][col];
                        geriausias = row+1;
                    }
                }
            }
            System.out.println("Geriausias mokinys: " + geriausias);
            double [] nepazangus = new double [m];
            int k = 0;
            for (int row = 0; row < m; row++) {
                for (int col = 0; col < v; col++) {
                    if (vidurkiai[row][col] < 5) {
                            nepazangus[k++] = vidurkiai[row][col];
                    }
                }
            }
            if (nepazangus[0] != 0) {
                for (int row = 0; row < k; row++) {
                    System.out.println("Nepazangus mokiniai: " + nepazangus[row]);
                }
            }
            else{
                System.out.println("Nepazangiu mokiniu nera");
            }
        }catch (FileNotFoundException e) {
            System.out.println("Ivyko klaida.");
        }

    }
}
