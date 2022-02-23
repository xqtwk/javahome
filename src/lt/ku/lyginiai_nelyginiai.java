package lt.ku;
import java.util.Scanner;
public class lyginiai_nelyginiai {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("iveskite skaiciu: ");
        int number = input.nextInt(), lyg = 0, nelyg = 0;
        for (int i = 1; number / i > 0; i *= 10) {
            if ((number / i) % 2 == 0) {
                lyg++;
            } else {
                nelyg++;
            }
        }
        System.out.println("lyginiu: " + lyg + "\n" + "nelyginiu: " + nelyg);
    }
}
