package lt.ku;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.*;

public class sveikieji_skaiciai {
    public static void main(String[] args) {
        int[] count = new int[10];
        String data = "";
        int foo;
        try {
            File file = new File("src/lt/ku/sveikieji_skaiciai.txt");
            Scanner finput = new Scanner(file);
            while (finput.hasNext()) {
                data = finput.next();
            }
            finput.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ivyko klaida.");
        }

        String[] darr = data.split("");

        for (int i = 0; i < darr.length; i++) {
            foo = Integer.parseInt(darr[i]);
            count[foo]++;
        }
        for (int i = 0; i < count.length; i++) {
            System.out.println( i + ":" + count[i]);
        }
    }
}
