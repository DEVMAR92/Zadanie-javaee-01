package pl.converter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/converterWeight")
public class ConverterWeightServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        String kilogramsString = request.getParameter("kilograms");
        String gramsString = request.getParameter("grams");
        String milligramsString = request.getParameter("milligrams");

        WeightConverter weightConverter = new WeightConverter(kilogramsString, gramsString, milligramsString);

        double[] results = weightConverter.convert();

        printWeight(writer, results);



    }




    private void printWeight(PrintWriter writer, double[] results) {

        if (results[1] > 0) {

            if (results[1] == 1) {
                writer.println("Podana wartosc w przeliczeniu na:");
                writer.println("Kilogramy: " + results[0]);
                writer.println("Gramy: " + results[0] * 1000);
                writer.println("MiliGramy: " + results[0] * 1000000);
            }
            if (results[1] == 2) {
                writer.println("Podana wartosc w przeliczeniu na:");
                writer.println("Kilogramy: " + results[0] / 1000);
                writer.println("Gramy: " + results[0]);
                writer.println("Miligramy: " + results[0] * 1000);
            }
            if (results[1] == 3) {
                writer.println("Podana wartosc w przeliczeniu na:");
                writer.println("Kilogramy: " + results[0] / 1000000);
                writer.println("Gramy: " + results[0] / 1000);
                writer.println("Miligramy: " + results[0]);
            }

        } else {
            writer.println("WPROWADZ JEDNA WARTOSC");
        }
    }
}
