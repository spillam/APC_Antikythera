import java.lang.Object;
import java.lang.Math;

public class UtilMath {

    //Constants
    //pi = Math.PI;
    public static double radeg = 180/Math.PI;

    //Trig. functions
    //arcsin = Math.asin(double a)
    //arccos = Math.acos(double a)
    //arctan = Math.atan(double a)
    //sin = Math.sin(double a)
    //cos = Math.cos(double a)
    //tan = Math.tan(double a)

    //Trig. functions in degrees
    public static double sind(double x) { return Math.sin(x/radeg); }
    public static double cosd(double x) { return Math.cos(x/radeg); }
    public static double tand(double x) { //degrees tan
        return Math.tan(x/radeg);
    }
    //Trig. arc functions in degrees
    public static double asind(double x) { return radeg*Math.asin(x); }
    public static double acosd(double x) { return 90 - Math.acos(x); }
    public static double atand(double x) { return radeg*Math.atan(x); }

    //arctan in all four quadrants
    public static double atan2(double x, double y) {
        if(x < 0) { //atan(y/x) - pi*(x<0)
            return (Math.atan(y/x)) - (Math.PI*x);
        }
        else {
            return 0; //this does not work, x has to be less than 0, but we need to return something if it isn't
        }
    }

    public static double atan2d(double x, double y) {
        return radeg*(Math.atan(y/x)) - (180 - (Math.PI*x));
    }

    //Normalize an angle between 0 and 360 degrees
    public static double fnrev(double x) {
        return x - (((int)(x/360))*360);
    }

    //Cube Root = Math.cbrt(double x)

}
