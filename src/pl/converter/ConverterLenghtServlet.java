package pl.converter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/converterLenght")
public class ConverterLenghtServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        String metersString = request.getParameter("meters");
        String centimetersString = request.getParameter("centimeters");
        String millimetersString = request.getParameter("millimeters");

        MetricalConverter metricalConverter = new MetricalConverter(metersString, centimetersString, millimetersString);

        double[] results = metricalConverter.convert();

        printMetrical(writer, results);

    }



    private void printMetrical(PrintWriter writer, double[] results) {

        if (results[1] > 0) {

            if (results[1] == 1) {
                writer.println("Podana wartosc w przeliczeniu na:");
                writer.println("Metry: " + results[0] + "\n");
                writer.println("Centymetry: " + results[0] * 100);
                writer.println("Milimetry: " + results[0] * 1000);
            }
            if (results[1] == 2) {
                writer.println("Podana wartosc w przeliczeniu na:");
                writer.println("Metry: " + results[0] / 100);
                writer.println("Centymetry: " + results[0]);
                writer.println("Milimetry: " + results[0] * 10);
            }
            if (results[1] == 3) {
                writer.println("Podana wartosc w przeliczeniu na:");
                writer.println("Metry: " + results[0] / 1000);
                writer.println("Centymetry: " + results[0] / 10);
                writer.println("Milimetry: " + results[0]);
            }

        } else {
            writer.println("WPROWADZ JEDNA WARTOSC");
        }
    }


}
