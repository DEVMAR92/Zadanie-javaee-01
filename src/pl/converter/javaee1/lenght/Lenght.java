package pl.converter.javaee1.lenght;

public class Lenght {

    //METERS

    public double meter(double value) {
        return value;
    }

    public double meterToCentimeter(double value) {
        return value * 100;
    }

    public double meterToMilimeter(double value) {
        return value * 1_000;
    }

    //CENTIMETERS

    public double centimetersToMeters(double value) {
        return value / 100;
    }

    public double centimeters(double value) {
        return value;
    }

    public double centimetersToMilimeters(double value) {
        return value * 10;
    }

    //MILIMETERS

    public double milimetersToMeters(double value) {
        return value / 1_000;
    }

    public double milimetersToCentimeters(double value) {
        return value / 100;
    }

    public double milimeters(double value) {
        return value;
    }
}
