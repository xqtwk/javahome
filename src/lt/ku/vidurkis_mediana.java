package lt.ku;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class vidurkis_mediana {
    public static void main(String[] args) {
        int [] startdata = new int [100];
        int count = 0;
        int n = 0;
        try {
            File file = new File("src/lt/ku/vidurkis_mediana.txt");
            Scanner finput = new Scanner(file);
            while (finput.hasNext()) {
                if( finput.hasNextInt()){
                    count++;
                }
                startdata[n++] = finput.nextInt();
            }
            finput.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ivyko klaida.");
        }
        int [] data = new int [count];

        for (int i = 0; i < data.length;) {
            for (int g = 0; g < data.length;) {
                data[i++] = startdata[g++];
            }
        }

        double sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum+= data[i];
        }
        sum = sum / data.length;

        System.out.println("Skaiciu vidurkis: " + sum);
        double med;
        Arrays.sort(data);

        if (data.length % 2 == 0)
            med = ((double)data[data.length/2] + (double)data[data.length/2 - 1])/2;
        else
            med = data[data.length/2];
        System.out.println("Skaiciu mediana: " + med);
    }
}
