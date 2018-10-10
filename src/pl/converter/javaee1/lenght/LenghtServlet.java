package pl.converter.javaee1.lenght;

import pl.converter.javaee1.lenght.Lenght;
import pl.converter.javaee1.weight.Weight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/lenght")
public class LenghtServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String metersString = request.getParameter("meters");
        String centimetersString = request.getParameter("centimeters");
        String milimetersString = request.getParameter("milimeters");
        Lenght lenght = new Lenght();

        if (check(metersString, centimetersString, milimetersString)) {
            writer.println("Błąd aplikacji");
            writer.println("Proszę wprowadzić TYLKO JEDNĄ wartość ");
        } else if (!(metersString.isEmpty())) {

            writer.println("Przeliczone wartości na: ");
            writer.println("METRY: " + lenght.meter(Double.valueOf(metersString)));
            writer.println("CENTYMETRY: " + lenght.meterToCentimeter(Double.valueOf(metersString)));
            writer.println("MILIMETRY: " + lenght.meterToMilimeter(Double.valueOf(metersString)));

        } else if (!(centimetersString.isEmpty())) {

            writer.println("Przeliczone wartości na: ");
            writer.println("METRY: " + lenght.centimetersToMeters(Double.valueOf(centimetersString)));
            writer.println("CENTYMETRY: " + lenght.centimeters(Double.valueOf(centimetersString)));
            writer.println("MILIMETRY: " + lenght.centimetersToMilimeters(Double.valueOf(centimetersString)));

        } else if (!(milimetersString.isEmpty())) {

            writer.println("Przeliczone wartości na: ");
            writer.println("METRY: " + lenght.milimetersToMeters(Double.valueOf(milimetersString)));
            writer.println("CENTYMETRY: " + lenght.milimetersToCentimeters(Double.valueOf(milimetersString)));
            writer.println("MILIMETRY: " + lenght.milimeters(Double.valueOf(milimetersString)));

        }


    }

    public boolean check(String first, String second, String third) {
        if (!first.isEmpty() && !second.isEmpty()
                || !first.isEmpty() && !third.isEmpty()
                || !second.isEmpty() && !third.isEmpty()
                || !first.isEmpty() && !second.isEmpty() && !third.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}