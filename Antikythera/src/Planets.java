import java.lang.Math;
public class Planets
{
    public static double node, inclination, perihelion, SMaxis, eccentricity,
            anomaly, E0, E1, x, y, r, v, xeclip, yeclip, zeclip, longitude, latitude;

    //Mercury position
    //note: eccentricity may need some modification
    public static void Mercury(double d) //d = computed Julian day number converter date
        {
            node = (48.3313 + (3.24587E-5*d))%360; //Long asc. node N
            inclination = (7.0047 + (5.00E-8*d))%360; //Inclination i
            perihelion = (29.1241 + (1.01444E-5*d))%360; //Arg. of perigelion w
            SMaxis = 0.387098; //Semi-major axis a
            eccentricity = (0.205635 + (5.59E-10*d)); //Eccentricity e
            anomaly = 168.6562 + 4.0923344368*d; // Mean anomaly M
            double M_normalized;
            M_normalized = UtilMath.fnrev(anomaly);
            E0 = M_normalized + (180/Math.PI) * eccentricity *
                    UtilMath.sind(M_normalized) * (1 + eccentricity * UtilMath.cosd(M_normalized));
            E1 = E0 - (E0 - (180/Math.PI) * eccentricity *
                    UtilMath.sind(E0) - M_normalized) / (1 + eccentricity * UtilMath.cosd(M_normalized));

            x = SMaxis * (UtilMath.cosd(E1) - eccentricity);
            y = SMaxis * Math.sqrt(1 - (eccentricity * eccentricity)) * UtilMath.sind(E1);
            r = Math.sqrt((x*x) + (y*y));
            v = UtilMath.atan2d(y, x);
            xeclip = r * (UtilMath.cosd(node) * UtilMath.cosd(v+perihelion) -
                    UtilMath.sind(node) * UtilMath.sind(v+perihelion) * UtilMath.cosd(inclination));
            yeclip = r * (UtilMath.sind(node) * UtilMath.cosd(v+perihelion) +
                    UtilMath.cosd(node) * UtilMath.sind(v+perihelion) * UtilMath.cosd(inclination));
            zeclip = r * UtilMath.sind(v+perihelion) * UtilMath.sind(inclination);

            longitude = UtilMath.fnrev(UtilMath.atan2d(yeclip, xeclip));
            latitude = UtilMath.atan2d(zeclip, Math.sqrt((xeclip * xeclip) + (yeclip * yeclip))); // still wrong
            //System.out.println(longitude);
            //System.out.println(latitude);

            System.out.println("Longitude of Ascension: " + node);
            System.out.println("Inclination: " + inclination);
            System.out.println("Argument of Perihelion: " + perihelion);
            System.out.println("Semi-major Axis: " + SMaxis);
            System.out.println("Eccentricity: " + eccentricity);
            System.out.println("Mean Anomaly: " + M_normalized);
            System.out.println("Eccentric Anomaly" + E1);
            System.out.println("Heliocentric distance: " + r);
            System.out.println("True Anomaly: " + v);
            System.out.println("Ecliptic Coordinate X:" + xeclip);
            System.out.println("Ecliptic Coordinate Y:" +yeclip);
            System.out.println("Ecliptic Coordinate Z:" +zeclip);
            System.out.println("Longitude: " + longitude);
            System.out.println("Latitude: " + latitude);


            //System.out.println(longitude);
            //System.out.println(latitude);

        }

    //Venus position
    public static void Venus(double d)
    {
        node = (76.6799+ (2.46590E-5*d))%360;
        inclination =( 3.3946 + (2.75E-8*d))%360;
        perihelion = (54.8910 + (1.38374E-5 * d))%360;
        SMaxis = 0.72333;
        eccentricity = (0.006773 - (1.302E-9*d));
        anomaly = (48.0052 + (1.6021302244 * d));
        double M_normalized;
        M_normalized = UtilMath.fnrev(anomaly);
        E0 = M_normalized + (180/Math.PI) * eccentricity *
                UtilMath.sind(M_normalized) * (1 + eccentricity * UtilMath.cosd(M_normalized));
        E1 = E0 - (E0 - (180/Math.PI) * eccentricity *
                UtilMath.sind(E0) - M_normalized) / (1 + eccentricity * UtilMath.cosd(M_normalized));

        x = SMaxis * (UtilMath.cosd(E1) - eccentricity);
        y = SMaxis * Math.sqrt(1 - (eccentricity * eccentricity)) * UtilMath.sind(E1);
        r = Math.sqrt((x*x) + (y*y));
        v = UtilMath.atan2d(y, x);
        xeclip = r * (UtilMath.cosd(node) * UtilMath.cosd(v+perihelion) -
                UtilMath.sind(node) * UtilMath.sind(v+perihelion) * UtilMath.cosd(inclination));
        yeclip = r * (UtilMath.sind(node) * UtilMath.cosd(v+perihelion) +
                UtilMath.cosd(node) * UtilMath.sind(v+perihelion) * UtilMath.cosd(inclination));
        zeclip = r * UtilMath.sind(v+perihelion) * UtilMath.sind(inclination);

        longitude = UtilMath.fnrev(UtilMath.atan2d(yeclip, xeclip));
        latitude = UtilMath.atan2d(zeclip, Math.sqrt((xeclip * xeclip) + (yeclip * yeclip))); // still wrong
        //System.out.println(longitude);
        //System.out.println(latitude);

        System.out.println("Longitude of Ascension: " + node);
        System.out.println("Inclination: " + inclination);
        System.out.println("Argument of Perihelion: " + perihelion);
        System.out.println("Semi-major Axis: " + SMaxis);
        System.out.println("Eccentricity: " + eccentricity);
        System.out.println("Mean Anomaly: " + M_normalized);
        System.out.println("Eccentric Anomaly" + E1);
        System.out.println("Heliocentric distance: " + r);
        System.out.println("True Anomaly: " + v);
        System.out.println("Ecliptic Coordinate X:" + xeclip);
        System.out.println("Ecliptic Coordinate Y:" +yeclip);
        System.out.println("Ecliptic Coordinate Z:" +zeclip);
        System.out.println("Longitude: " + longitude);
        System.out.println("Latitude: " + latitude);
    }

    //Mars position
    public static void Mars(double d)
    {
        node = (49.5574 + (2.11081E-5 * d))%360;
        inclination = (1.8497 - (1.78E-8*d))%360;
        perihelion = (286.5016 + (2.92961E-5*d))%360;
        SMaxis = 1.523688;
        eccentricity = (0.093405+ (2.516E-9* d));
        anomaly = (18.6021 + (0.5240207766 * d ));
        double M_normalized;
        M_normalized = UtilMath.fnrev(anomaly);
        E0 = M_normalized + (180/Math.PI) * eccentricity *
                UtilMath.sind(M_normalized) * (1 + eccentricity * UtilMath.cosd(M_normalized));
        E1 = E0 - (E0 - (180/Math.PI) * eccentricity *
                UtilMath.sind(E0) - M_normalized) / (1 + eccentricity * UtilMath.cosd(M_normalized));

        x = SMaxis * (UtilMath.cosd(E1) - eccentricity);
        y = SMaxis * Math.sqrt(1 - (eccentricity * eccentricity)) * UtilMath.sind(E1);
        r = Math.sqrt((x*x) + (y*y));
        v = UtilMath.atan2d(y, x);
        xeclip = r * (UtilMath.cosd(node) * UtilMath.cosd(v+perihelion) -
                UtilMath.sind(node) * UtilMath.sind(v+perihelion) * UtilMath.cosd(inclination));
        yeclip = r * (UtilMath.sind(node) * UtilMath.cosd(v+perihelion) +
                UtilMath.cosd(node) * UtilMath.sind(v+perihelion) * UtilMath.cosd(inclination));
        zeclip = r * UtilMath.sind(v+perihelion) * UtilMath.sind(inclination);

        longitude = UtilMath.fnrev(UtilMath.atan2d(yeclip, xeclip));
        latitude = UtilMath.atan2d(zeclip, Math.sqrt((xeclip * xeclip) + (yeclip * yeclip))); // still wrong
        //System.out.println(longitude);
        //System.out.println(latitude);

        System.out.println("Longitude of Ascension: " + node);
        System.out.println("Inclination: " + inclination);
        System.out.println("Argument of Perihelion: " + perihelion);
        System.out.println("Semi-major Axis: " + SMaxis);
        System.out.println("Eccentricity: " + eccentricity);
        System.out.println("Mean Anomaly: " + M_normalized);
        System.out.println("Eccentric Anomaly" + E1);
        System.out.println("Heliocentric distance: " + r);
        System.out.println("True Anomaly: " + v);
        System.out.println("Ecliptic Coordinate X:" + xeclip);
        System.out.println("Ecliptic Coordinate Y:" +yeclip);
        System.out.println("Ecliptic Coordinate Z:" +zeclip);
        System.out.println("Longitude: " + longitude);
        System.out.println("Latitude: " + latitude);
    }

    //Jupiter position
    public static void Jupiter(double d)
    {
        node = (100.4542 + (2.76854E-5 * d ))%360;
        inclination = (1.3030 - (1.557E-7 * d))%360;
        perihelion = (273.8777 + (1.64505E-5 * d))%360;
        SMaxis = 5.20256;
        eccentricity = (0.048498 + (4.469E-9 * d));
        anomaly = (19.8950 +(0.0830853001 * d));
        double M_normalized;
        M_normalized = UtilMath.fnrev(anomaly);
        E0 = M_normalized + (180/Math.PI) * eccentricity *
                UtilMath.sind(M_normalized) * (1 + eccentricity * UtilMath.cosd(M_normalized));
        E1 = E0 - (E0 - (180/Math.PI) * eccentricity *
                UtilMath.sind(E0) - M_normalized) / (1 + eccentricity * UtilMath.cosd(M_normalized));

        x = SMaxis * (UtilMath.cosd(E1) - eccentricity);
        y = SMaxis * Math.sqrt(1 - (eccentricity * eccentricity)) * UtilMath.sind(E1);
        r = Math.sqrt((x*x) + (y*y));
        v = UtilMath.atan2d(y, x);
        xeclip = r * (UtilMath.cosd(node) * UtilMath.cosd(v+perihelion) -
                UtilMath.sind(node) * UtilMath.sind(v+perihelion) * UtilMath.cosd(inclination));
        yeclip = r * (UtilMath.sind(node) * UtilMath.cosd(v+perihelion) +
                UtilMath.cosd(node) * UtilMath.sind(v+perihelion) * UtilMath.cosd(inclination));
        zeclip = r * UtilMath.sind(v+perihelion) * UtilMath.sind(inclination);

        longitude = UtilMath.fnrev(UtilMath.atan2d(yeclip, xeclip));
        latitude = UtilMath.atan2d(zeclip, Math.sqrt((xeclip * xeclip) + (yeclip * yeclip))); // still wrong
        //System.out.println(longitude);
        //System.out.println(latitude);

        System.out.println("Longitude of Ascension: " + node);
        System.out.println("Inclination: " + inclination);
        System.out.println("Argument of Perihelion: " + perihelion);
        System.out.println("Semi-major Axis: " + SMaxis);
        System.out.println("Eccentricity: " + eccentricity);
        System.out.println("Mean Anomaly: " + M_normalized);
        System.out.println("Eccentric Anomaly" + E1);
        System.out.println("Heliocentric distance: " + r);
        System.out.println("True Anomaly: " + v);
        System.out.println("Ecliptic Coordinate X:" + xeclip);
        System.out.println("Ecliptic Coordinate Y:" +yeclip);
        System.out.println("Ecliptic Coordinate Z:" +zeclip);
        System.out.println("Longitude: " + longitude);
        System.out.println("Latitude: " + latitude);
    }

    //Saturn position
    public static void Saturn(double d)
    {
        node = (113.6634 + (2.38980E-5 * d))%360;
        inclination = ( 2.4886 - (1.081E-7 * d))%360;
        perihelion = (339.3939 + (2.97661E-5 * d))%360;
        SMaxis = 9.55475;
        eccentricity = 0.055546- (9.499E-9 * d);
        anomaly = (316.9670 + (0.0334442282 * d));
        double M_normalized;
        M_normalized = UtilMath.fnrev(anomaly);
        E0 = M_normalized + (180/Math.PI) * eccentricity *
                UtilMath.sind(M_normalized) * (1 + eccentricity * UtilMath.cosd(M_normalized));
        E1 = E0 - (E0 - (180/Math.PI) * eccentricity *
                UtilMath.sind(E0) - M_normalized) / (1 + eccentricity * UtilMath.cosd(M_normalized));

        x = SMaxis * (UtilMath.cosd(E1) - eccentricity);
        y = SMaxis * Math.sqrt(1 - (eccentricity * eccentricity)) * UtilMath.sind(E1);
        r = Math.sqrt((x*x) + (y*y));
        v = UtilMath.atan2d(y, x);
        xeclip = r * (UtilMath.cosd(node) * UtilMath.cosd(v+perihelion) -
                UtilMath.sind(node) * UtilMath.sind(v+perihelion) * UtilMath.cosd(inclination));
        yeclip = r * (UtilMath.sind(node) * UtilMath.cosd(v+perihelion) +
                UtilMath.cosd(node) * UtilMath.sind(v+perihelion) * UtilMath.cosd(inclination));
        zeclip = r * UtilMath.sind(v+perihelion) * UtilMath.sind(inclination);

        longitude = UtilMath.fnrev(UtilMath.atan2d(yeclip, xeclip));
        latitude = UtilMath.atan2d(zeclip, Math.sqrt((xeclip * xeclip) + (yeclip * yeclip))); // still wrong
        //System.out.println(longitude);
        //System.out.println(latitude);

        System.out.println("Longitude of Ascension: " + node);
        System.out.println("Inclination: " + inclination);
        System.out.println("Argument of Perihelion: " + perihelion);
        System.out.println("Semi-major Axis: " + SMaxis);
        System.out.println("Eccentricity: " + eccentricity);
        System.out.println("Mean Anomaly: " + M_normalized);
        System.out.println("Eccentric Anomaly" + E1);
        System.out.println("Heliocentric distance: " + r);
        System.out.println("True Anomaly: " + v);
        System.out.println("Ecliptic Coordinate X:" + xeclip);
        System.out.println("Ecliptic Coordinate Y:" +yeclip);
        System.out.println("Ecliptic Coordinate Z:" +zeclip);
        System.out.println("Longitude: " + longitude);
        System.out.println("Latitude: " + latitude);
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
        double M_normalized;
        M_normalized = UtilMath.fnrev(anomaly);
        E0 = M_normalized + (180/Math.PI) * eccentricity *
                UtilMath.sind(M_normalized) * (1 + eccentricity * UtilMath.cosd(M_normalized));
        E1 = E0 - (E0 - (180/Math.PI) * eccentricity *
                UtilMath.sind(E0) - M_normalized) / (1 + eccentricity * UtilMath.cosd(M_normalized));

        x = SMaxis * (UtilMath.cosd(E1) - eccentricity);
        y = SMaxis * Math.sqrt(1 - (eccentricity * eccentricity)) * UtilMath.sind(E1);
        r = Math.sqrt((x*x) + (y*y));
        v = UtilMath.atan2d(y, x);
        xeclip = r * (UtilMath.cosd(node) * UtilMath.cosd(v+perihelion) -
                UtilMath.sind(node) * UtilMath.sind(v+perihelion) * UtilMath.cosd(inclination));
        yeclip = r * (UtilMath.sind(node) * UtilMath.cosd(v+perihelion) +
                UtilMath.cosd(node) * UtilMath.sind(v+perihelion) * UtilMath.cosd(inclination));
        zeclip = r * UtilMath.sind(v+perihelion) * UtilMath.sind(inclination);

        longitude = UtilMath.fnrev(UtilMath.atan2d(yeclip, xeclip));
        latitude = UtilMath.atan2d(zeclip, Math.sqrt((xeclip * xeclip) + (yeclip * yeclip))); // still wrong
        //System.out.println(longitude);
        //System.out.println(latitude);

        System.out.println("Longitude of Ascension: " + node);
        System.out.println("Inclination: " + inclination);
        System.out.println("Argument of Perihelion: " + perihelion);
        System.out.println("Semi-major Axis: " + SMaxis);
        System.out.println("Eccentricity: " + eccentricity);
        System.out.println("Mean Anomaly: " + M_normalized);
        System.out.println("Eccentric Anomaly" + E1);
        System.out.println("Heliocentric distance: " + r);
        System.out.println("True Anomaly: " + v);
        System.out.println("Ecliptic Coordinate X:" + xeclip);
        System.out.println("Ecliptic Coordinate Y:" +yeclip);
        System.out.println("Ecliptic Coordinate Z:" +zeclip);
        System.out.println("Longitude: " + longitude);
        System.out.println("Latitude: " + latitude);
    }

    //Neptune position
    public static void Neptune(double d)
    {
        node = (131.7806 + (3.0173E-5 * d))%360;
        inclination = (1.7700 - (2.55E-7 * d ))%360;
        perihelion = (272.8461 - (6.027E-6 * d))%360;
        SMaxis = 30.05826 + (3.313E-8 * d);
        eccentricity = (0.008606 + (2.15E-9 * d));
        anomaly = (260.2471 + (0.005995147 * d));
        double M_normalized;
        M_normalized = UtilMath.fnrev(anomaly);
        E0 = M_normalized + (180/Math.PI) * eccentricity *
                UtilMath.sind(M_normalized) * (1 + eccentricity * UtilMath.cosd(M_normalized));
        E1 = E0 - (E0 - (180/Math.PI) * eccentricity *
                UtilMath.sind(E0) - M_normalized) / (1 + eccentricity * UtilMath.cosd(M_normalized));

        x = SMaxis * (UtilMath.cosd(E1) - eccentricity);
        y = SMaxis * Math.sqrt(1 - (eccentricity * eccentricity)) * UtilMath.sind(E1);
        r = Math.sqrt((x*x) + (y*y));
        v = UtilMath.atan2d(y, x);
        xeclip = r * (UtilMath.cosd(node) * UtilMath.cosd(v+perihelion) -
                UtilMath.sind(node) * UtilMath.sind(v+perihelion) * UtilMath.cosd(inclination));
        yeclip = r * (UtilMath.sind(node) * UtilMath.cosd(v+perihelion) +
                UtilMath.cosd(node) * UtilMath.sind(v+perihelion) * UtilMath.cosd(inclination));
        zeclip = r * UtilMath.sind(v+perihelion) * UtilMath.sind(inclination);

        longitude = UtilMath.fnrev(UtilMath.atan2d(yeclip, xeclip));
        latitude = UtilMath.atan2d(zeclip, Math.sqrt((xeclip * xeclip) + (yeclip * yeclip))); // still wrong
        //System.out.println(longitude);
        //System.out.println(latitude);

        System.out.println("Longitude of Ascension: " + node);
        System.out.println("Inclination: " + inclination);
        System.out.println("Argument of Perihelion: " + perihelion);
        System.out.println("Semi-major Axis: " + SMaxis);
        System.out.println("Eccentricity: " + eccentricity);
        System.out.println("Mean Anomaly: " + M_normalized);
        System.out.println("Eccentric Anomaly" + E1);
        System.out.println("Heliocentric distance: " + r);
        System.out.println("True Anomaly: " + v);
        System.out.println("Ecliptic Coordinate X:" + xeclip);
        System.out.println("Ecliptic Coordinate Y:" +yeclip);
        System.out.println("Ecliptic Coordinate Z:" +zeclip);
        System.out.println("Longitude: " + longitude);
        System.out.println("Latitude: " + latitude);

    }

    //Sun position --> stationary, but somewhat needed for your point of view
    public static void Sun(double d)
    {
        node = 0; //Long asc. node N
        inclination = 0; //Inclination i
        perihelion = (282.9404 + (4.70935E-5*d)); //Arg. of perigelion w --> the angle between acending node and perihelion, becomes equal to the longitude of the perihelion
        SMaxis = 1.0; //Semi-major axis a
        eccentricity = (0.016709 + (1.151E-9*d)); //Eccentricity e
        anomaly = (356.0470 + 0.9856002585*d); // Mean anomaly M

        double oblcl = (23.4393 - (3.563E-7 * d)); //obliquity of ecliptic
        //supposed on April 19 1990, JD = -3543
        //w = 282.7735_deg
        //a = 1.000000
        //e = 0.016713
        //M = -3135.9347_deg
        if (anomaly < 0) {
            anomaly = 360 - (((anomaly * -1)%360));
        }
        else
        {
            anomaly = anomaly%360;
        }
        anomaly = UtilMath.fnrev(anomaly);
        longitude = (perihelion + anomaly)%360;//mean longitude of the sun

        E0 = anomaly + (180/Math.PI) * eccentricity *UtilMath.sind(anomaly) * (1+eccentricity*UtilMath.cosd(anomaly));
        x = Math.cos(E0) - eccentricity;
        y = Math.sin(E0) * Math.sqrt(1- eccentricity*eccentricity);

        r = Math.sqrt(x*x + y*y);
        v = Math.atan2(y,x);

        longitude = v + perihelion; //on April 19 1990
        // lon = 105.9134_deg + 282.7735_deg = 388.6869_deg = 28.6869_deg
        //      Our results    Astron. Almanac      Difference

        //lon    28.6869_deg      28.6813_deg        +0.0056_deg = 20"
        //r       1.004323         1.004311          +0.000012
        System.out.println("Longitude of Ascension: " + node);
        System.out.println("Inclination: " + inclination);
        System.out.println("Argument of Perihelion: " + perihelion);
        System.out.println("Semi-major Axis: " + SMaxis);
        System.out.println("Eccentricity: " + eccentricity);
        System.out.println("Heliocentric distance: " + r);
        System.out.println("True Anomaly: " + v);
        System.out.println("Longitude: " + longitude);
        System.out.println("Latitude: " + latitude);

    }

    //Moon position
    //anomaly, E0, E1, x, y, r, v, xeclip, yeclip, zeclip, longitude, latitude;
    public static void Moon(double d)
    {
        node = (125.1228 - (0.0529538083 * d)); //N
        inclination = 5.1454; //i
        perihelion = (318.0634 + (0.1643573223 * d)); //w
        SMaxis = 60.2666; //a
        eccentricity = 0.054900; //e
        anomaly = (115.3654 + (13.0649929509 * d)); //M

        if (anomaly < 0) {
            anomaly = 360 - (((anomaly * -1)%360));
        }
        else
        {
            anomaly = anomaly%360;
        }
        E0 = anomaly + (180/Math.PI) * eccentricity *UtilMath.sind(anomaly)
                * (1+eccentricity*UtilMath.cosd(anomaly));
        E1 = E0 - ((E0 - (180/Math.PI)* eccentricity *UtilMath.sind(E0) - anomaly)
                / (1-eccentricity*UtilMath.cosd(E0)));
        //E0 == 262.9735 and E1 = 262.9735

        x = SMaxis*(Math.cos(E0) - eccentricity);
        y = SMaxis * Math.sqrt(1- eccentricity*eccentricity) * UtilMath.sind(E0);

        r = Math.sqrt(x*x + y*y); //60.67134 Earth radii
        v = Math.atan2(y,x); //259.8605_deg

        xeclip = r * (UtilMath.cosd(node)*UtilMath.cosd(v+perihelion)
                - UtilMath.sind(node)*UtilMath.sind(v+perihelion)*UtilMath.cosd(inclination));
        yeclip = r * (UtilMath.sind(node)*UtilMath.cosd(v+perihelion)
                + UtilMath.cosd(node)*UtilMath.sind(v+perihelion)*UtilMath.cosd(inclination));
        zeclip = r * UtilMath.sind(v+perihelion) * UtilMath.sind(inclination);

        //xc = xeclip = +37.65311
        //yc = yeclip = -47.57180
        //zc = zeclip =  -0.41687

        longitude = UtilMath.atan2(yeclip, xeclip);
        latitude = UtilMath.atan2(zeclip, Math.sqrt(xeclip*xeclip + yeclip*yeclip));
        r = Math.sqrt(xeclip*xeclip + yeclip*yeclip + zeclip*zeclip);
        //long = 308.3616_deg
        //lat  =  -0.3937_deg
        //r    =  60.6713

        System.out.println("Longitude of Ascension: " + node);
        System.out.println("Inclination: " + inclination);
        System.out.println("Argument of Perihelion: " + perihelion);
        System.out.println("Semi-major Axis: " + SMaxis);
        System.out.println("Eccentricity: " + eccentricity);
        System.out.println("Eccentric Anomaly:" + E0);
        System.out.println("Final Eccentric Anomaly" + E1);
        System.out.println("Heliocentric distance: " + r);
        System.out.println("True Anomaly: " + v);
        System.out.println("Ecliptic Coordinate X:" + xeclip);
        System.out.println("Ecliptic Coordinate Y:" +yeclip);
        System.out.println("Ecliptic Coordinate Z:" +zeclip);
        System.out.println("Longitude: " + longitude);
        System.out.println("Latitude: " + latitude);
    }
}