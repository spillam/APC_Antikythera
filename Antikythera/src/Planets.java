public class Planets
{
    public double node, inclination, perihelion, SMaxis, eccentricity, anomaly;

    //Mercury position
    //note: eccentricity may need some modification
    public static void Mercury(double d) //d = computed Julian day number converter date
        {
            node = (48.3313 + (3.24587E-5*d))%360;
            inclination = (7.0047 + (5.00E-8*d))%360;
            perihelion = (29.1241 + (1.01444E-5*d))%360;
            SMaxis = 0.387098;
            eccentricity = (0.205635 + (5.59E-10*d));
            anomaly = 168.6562 + 4.0923344368*d;

        }

    //Venus position
    public static void Venus(double d)
    {
        node = (76.6799+ (2.46590E-5*d))%360;
        inclination =( 3.3946 + (2.75E-8*d))%360;
        perihelion = (54.8910 + (1.38374E-5 * d))%360;
        SMaxis = 0.72333;
        eccentricity = (0.006773 - (1.302E-9*d));
        anomaly = (48.0052 + (1.6021302244 * d))%360;

    }

    //Mars position
    public static void Mars(double d)
    {
        node = (49.5574 + (2.11081E-5 * d))%360;
        inclination = (1.8497 - (1.78E-8*d))%360;
        perihelion = (286.5016 + (2.92961E-5*d))%360;
        SMaxis = 1.523688;
        eccentricity = (0.093405+ (2.516E-9* d));
        anomaly = (18.6021 + (0.5240207766 * d ))%360;

    }

    //Jupiter position
    public static void Jupiter(double d)
    {
        node = (100.4542 + (2.76854E-5 * d ))%360;
        inclination = (1.3030 - (1.557E-7 * d))%360;
        perihelion = (273.8777 + (1.64505E-5 * d))%360;
        SMaxis = 5.20256;
        eccentricity = (0.048498 + (4.469E-9 * d));
        anomaly = (19.8950 +(0.0830853001 * d))%360;

    }

    //Saturn position
    public static void Saturn(double d)
    {
        node = (113.6634 + (2.38980E-5 * d))%360;
        inclination = ( 2.4886 - (1.081E-7 * d))%360;
        perihelion = (339.3939 + (2.97661E-5 * d))%360;
        SMaxis = 9.55475;
        eccentricity = 0.055546- (9.499E-9 * d);
        anomaly = (316.9670 + (0.0334442282 * d))%360;
    }

    //Uranus position
    public static void Uranus(double d)
    {
        node = (74.0005 + (1.3978E-5 * d))%360;
        inclination = (0.7733 + (1.9E-8 * d ))%360;
        perihelion = (96.6612 + (3.0565E-5 * d))%360;
        SMaxis = 19.18171 - (1.55E-8 * d);
        eccentricity = (0.047318 + (7.45E-9 * d));
        anomaly = (142.5905 + (0.011725806  * d));
    }

    //Neptune position
    public static void Neptune(double d)
    {
        node = (131.7806 + (3.0173E-5 * d))%360;
        inclination = (1.7700 - (2.55E-7 * d ))%360;
        perihelion = (272.8461 - (6.027E-6 * d))%360;
        SMaxis = 30.05826 + (3.313E-8 * d);
        eccentricity = (0.008606 + (2.15E-9 * d));
        anomaly = (260.2471 + (0.005995147 * d))%360;

    }

}
