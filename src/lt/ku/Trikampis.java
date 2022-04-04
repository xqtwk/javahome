package lt.ku;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Trikampis {
    private int x,y,z;
    public static class LygiakrastisTrikampis {
        private double x,y,z;

        public LygiakrastisTrikampis(double a){
            x = a; y = a; z = a;
        }

        public double plotas(){
            double result = (Math.sqrt(3)*Math.pow(x,2))/4;
            return result;
        }
    }
    public static void main(String[] args) {
        Trikampis A = new Trikampis(5,6,7);
        StatusisTrikampis B = new StatusisTrikampis(5,8);
        LygiakrastisTrikampis C = new LygiakrastisTrikampis(6);
        System.out.println("plotas: " + + A.plotas());
        System.out.println("Staciojo plotas: " + B.plotas());
        System.out.println("Lygiakrascio plotas: " + C.plotas());
        ArrayList<Object> lst = new ArrayList<Object>();
        lst.add(A);
        lst.add(B);
        lst.add(C);
        System.out.println(plotuSuma(lst));
    }

    public Trikampis(){

    }

    public Trikampis(int a, int b, int c){
        x = a; y = b; z = c;
    }

    public double plotas(){
        double result = Math.sqrt(((x+y+z)/2)*(((x+y+z)/2)-x)*(((x+y+z)/2)-y)*(((x+y+z)/2)-z));
        return result;
    }
    public static double plotuSuma(ArrayList list) {
        double sum = 0;
        for (Object obj : list) {
            if (obj.getClass() == StatusisTrikampis.class) {
                StatusisTrikampis trikampis = (StatusisTrikampis) obj;
                sum += trikampis.plotas();
            }
            if (obj.getClass() == LygiakrastisTrikampis.class) {
                LygiakrastisTrikampis trikampis = (LygiakrastisTrikampis) obj;
                sum += trikampis.plotas();
            }
            if (obj.getClass() == Trikampis.class) {
                Trikampis trikampis = (Trikampis) obj;
                sum += trikampis.plotas();
            }
        }
        return sum;
    }
}
