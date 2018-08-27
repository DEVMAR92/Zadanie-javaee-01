package pl.converter;

public class WeightConverter implements Convertable {
    private String kilograms;
    private String grams;
    private String milligrams;


    public WeightConverter(String kilograms, String grams, String milligrams) {
        this.kilograms = kilograms;
        this.grams = grams;
        this.milligrams = milligrams;
    }


    @Override
    public double[] convert() {
        double[] results = new double[2];

        if (kilograms.isEmpty() && grams.isEmpty() && milligrams.isEmpty()) {
            results[1] = -1;
            return results;
        }
        if (!(kilograms.isEmpty()) && grams.isEmpty() && milligrams.isEmpty()) {
            double kil = Double.valueOf(kilograms);
            results[0] = kil;
            results[1] = 1;
            return results;
        }
        if (kilograms.isEmpty() && !(grams.isEmpty()) && milligrams.isEmpty()) {
            double gr = Double.valueOf(grams);
            results[0] = gr;
            results[1] = 2;
            return results;
        }
        if (kilograms.isEmpty() && grams.isEmpty()) {
            double mingr = Double.valueOf(milligrams);
            results[0] = mingr;
            results[1] = 3;
            return results;

        } else {
            results[1] = -1;
            return results;
        }
    }
}
