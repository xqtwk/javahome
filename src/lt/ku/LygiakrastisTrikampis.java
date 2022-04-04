package lt.ku;

public class LygiakrastisTrikampis {
    private double x,y,z;

    public LygiakrastisTrikampis(double a){
        x = a; y = a; z = a;
    }

    public double plotas(){
        double result = (Math.sqrt(3)*Math.pow(x,2))/4;
        return result;
    }
}