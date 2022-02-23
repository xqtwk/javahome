package lt.ku;
import java.util.Scanner;
import java.io.*;

public class armstrongo_skaicius {
    public static boolean check(int x)
    {
        int number, digits=0, last=0, sum=0;
        number=x;
        while(number>0)
        {
            number = number/10;
            digits++;
        }
        number = x;
        while(number>0)
        {
            last = number % 10;
            sum +=  (Math.pow(last, digits));
            number = number/10;
        }
        if(x==sum) {
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args)
    {
        int limit = 0;
        try {
            File file = new File("src/lt/ku/armstrongoskaicius.txt");
            Scanner finput = new Scanner(file);
            while (finput.hasNextLine()) {
                String data = finput.nextLine();
                limit = Integer.parseInt(data);
            }
            finput.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ivyko klaida.");
        }
        System.out.println("Armstrongo skaiciai iki "+ limit + ": ");
        for(int i=0; i<=limit; i++)
            if(check(i))
                System.out.print(i+ ", ");
    }
}

