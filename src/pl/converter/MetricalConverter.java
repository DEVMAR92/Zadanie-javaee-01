package pl.converter;

public class MetricalConverter implements Convertable {

    private String meters;
    private String centimeters;
    private String millimeters;



    public MetricalConverter(String meters, String centimeters, String millimeters) {
        this.meters = meters;
        this.centimeters = centimeters;
        this.millimeters = millimeters;

    }

    @Override
    public double[] convert() {
        double[] results = new double[2];

        if (meters.isEmpty() && centimeters.isEmpty() && millimeters.isEmpty()) {
            results[1] = -1;
            return results;
        }
        if (!(meters.isEmpty()) && centimeters.isEmpty() && millimeters.isEmpty()) {
            double met = Double.valueOf(meters);
            results[0] = met;
            results[1] = 1;
            return results;
        }
        if (meters.isEmpty() && !(centimeters.isEmpty()) && millimeters.isEmpty()) {
            double cenmet = Double.valueOf(centimeters);
            results[0] = cenmet;
            results[1] = 2;
            return results;
        }
        if (meters.isEmpty() && centimeters.isEmpty()) {
            double minmet = Double.valueOf(millimeters);
            results[0] = minmet;
            results[1] = 3;
            return results;

        } else {
            results[1] = -1;
            return results;
        }
    }
}
