package lt.ku;
import java.util.Scanner;
public class trikampio_plotas { // uzduotis N1
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("iveskite trikampio krastines a,b,c: " );
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double p = (a+b+c)/2 ;
        double result = Math.sqrt(Math.abs(p*(p-a)*(p-b)*(p-c)));
        System.out.println("Trikampio plotas: " + result);
    }
}
