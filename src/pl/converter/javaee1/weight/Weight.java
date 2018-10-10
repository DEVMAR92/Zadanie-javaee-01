package pl.converter.javaee1.weight;

public class Weight {

    //KILOGRAMS

    public double kilogram(double value) {
        return value;
    }

    public double kilogramToGram(double value) {
        return value * 1_000;
    }

    public double kilogramToMiligram(double value) {
        return value * 1_000_000;
    }

    //GRAMS

    public double gramToKilogram(double value) {
        return value / 1_000;
    }

    public double gram(double value) {
        return value;
    }

    public double gramToMiligram(double value) {
        return value * 1_000;
    }

    //MILIGRAMS

    public double miligramToKilogram(double value) {
        return value / 1_000_000;
    }

    public double miligramToGram(double value) {
        return value / 1_000;
    }

    public double miligram(double value) {
        return value;
    }
}
