package lt.ku;

public class StatusisTrikampis {
    private double x,y,z;

    public StatusisTrikampis(double a, double b){
        x = a; y = b;
        z = Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
    }

    public double plotas(){
        double result = (this.x+this.y)/2;
        return result;
    }
}