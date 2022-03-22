package lt.ku;
import static java.lang.Math.*;

/** Klase point
 * @author Richard Droba
 * @version 1.0
 *
 *
 */
public class Point {
    /** x, y */
    private int x, y;
    public static void main(String[] args) {
        /** testavimas*/
        Point vienas = new Point(5, 6);
        Point b = new Point(-35, 12);
        vienas.to_String();
        System.out.println(vienas.distanceFromOrigin(vienas.get_x(), vienas.get_y()));
        vienas.translate(1, 2);
        System.out.println(vienas.get_x());
        System.out.println(vienas.get_y());
        vienas.setLocation(6, 6);
        vienas.to_String();
        System.out.println(vienas.distance(b));
    }

    /**
     * konstruktorius - naujo objekto sukurimas
     * */
    public Point(){
    }

    /**
     * konstruktorius - naujo objekto sukurimas su nustatytais x,y
     * @param x - taskas x
     * @param y - taskas y
     * */
    public Point(int x, int y){
        set_x(x);
        set_y(y);
    }

    /**
     * x setter
     * @param c - x
     */
    public void set_x(int c) {
        this.x = c;
    }
    /**
     * y setter
     * @param c - y
     */
    public void set_y(int c) {
        this.y = c;
    }

    /**
     * x getter
     * @return grazina x
     */
    public int get_x() {
        return x;
    }

    /**
     * y getter
     * @return grazina y
     */
    public int get_y() {
        return y;
    }

    /**
     * metodas distanceFromOrigin - skaiciuoja atstuma nuo koord. pradzios iki tasko
     * @param x - x
     * @param y - y
     */
    double distanceFromOrigin(int x, int y) {
        double range = sqrt(pow(x, 2)+pow(y, 2));
        return range;
    }

    /**
     * metodas translate  - perstumia taska
     * @param dx - kiek stumsime tasko x
     * @param dy - kiek stumsime tasko y
     * */
    void translate(int dx, int dy) {
        dx += get_x();
        dy += get_y();
        set_x(dx);
        set_y(dy);
    }

    /**
     * tasko vietos atvaizdavimas formatu [x;y]
     */
    void to_String(){
        System.out.println("[" + get_x() + ";" + get_y() + "]");
    }

    /**
     * grazina atstumą iki taško p nuo esamos taško.
     * @param p - objektas(taskas)
     */
    double distance(Point p){
        double range = sqrt(pow(p.get_x()-get_x(),2)+pow(p.get_y()-get_y(),2));
        return range;
    }

    /**
     * pakeicia esamo taško koordinates i nurodomas
     * @param x - kokiu skaiciu pakeisime tasko koordinate x
     * @param y - kokiu skaiciu pakeisime tasko koordinate y
     */
    void setLocation(int x, int y){
        set_x(x);
        set_y(y);
    }
}
