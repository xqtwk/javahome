package lt.ku;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Line {
    private static Point p1;// = new Point(1, 2);
    private static Point p2;// = new Point(3, 4);
    public static void main(String[] args) {
        Point x = new Point(1,2);
        Point y = new Point(3,4);
        Line linija = new Line(x, y);
        linija.to_String();
        System.out.println("Linijos iligs tarp 2 tasku: " + linija.countLength());
    }

    public Line(){

    }
    public Line(Point a, Point b){
    p1 = a; p2 = b;
    }
    public void set_p1(Point c) {
        this.p1 = c;
    }


    public void set_p2(Point c) {
        this.p2 = c;
    }


    public int[] get_p1() { return ( new int[] {  p1.get_x(), p1.get_y()}); }
        //return p1.get_x(), p1.get_y(); }


    public int[] get_p2() { return ( new int[] {  p2.get_x(), p2.get_y()});}


    void to_String(){
        System.out.println("[" + get_p1()[0] + ";" + get_p1()[1] + "]" + " " + "[" + get_p2()[0] + ";" + get_p2()[1] + "]");
    }
    public double countLength(){
        double result = sqrt(pow(p1.get_x()-p2.get_x(),2)+pow(p2.get_y()-p1.get_y(),2));
        return result;
    }
}
