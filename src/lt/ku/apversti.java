package lt.ku;

import java.util.Scanner;

public class apversti {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Iveskite skaiciu: ");
        int x = input.nextInt();
        reverse(x);
    }
    public static int reverse(int x){
        int n2 = 0, digit = 0;
        int nmb = x;
        if (x>0) {
            digit = nmb % 10;
            nmb = nmb / 10;
            n2 += digit;
            System.out.print(n2);
            return reverse(nmb);
        }
        else{
            return 0;
        }
    }
}
