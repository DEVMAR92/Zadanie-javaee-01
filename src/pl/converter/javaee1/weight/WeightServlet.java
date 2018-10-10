package pl.converter.javaee1.weight;

import pl.converter.javaee1.weight.Weight;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/weight")
public class WeightServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String kilogramsString = request.getParameter("kilograms");
        String gramsString = request.getParameter("grams");
        String milligramsString = request.getParameter("milligrams");
        Weight weight = new Weight();

        if (check(kilogramsString, gramsString, milligramsString)) {
            writer.println("Błąd aplikacji");
            writer.println("Proszę wprowadzić TYLKO JEDNĄ wartość ");
        } else if (!(kilogramsString.isEmpty())) {

            writer.println("Przeliczone wartości na:");
            writer.println("KILOGRAMY: " + weight.kilogram(Double.valueOf(kilogramsString)));
            writer.println("GRAMY: " + weight.kilogramToGram(Double.valueOf(kilogramsString)));
            writer.println("MILIGRAMY: " + weight.kilogramToMiligram(Double.valueOf(kilogramsString)));

        } else if (!(gramsString.isEmpty())) {

            writer.println("Przeliczone wartości na:");
            writer.println("KILOGRAMY: " + weight.gramToKilogram(Double.valueOf(gramsString)));
            writer.println("GRAMY: " + weight.gram(Double.valueOf(gramsString)));
            writer.println("MILIGRAMY: " + weight.gramToMiligram(Double.valueOf(gramsString)));

        } else if (!(milligramsString.isEmpty())) {

            writer.println("Przeliczone wartości na:");
            writer.println("KILOGRAMY: " + weight.miligramToKilogram(Double.valueOf(milligramsString)));
            writer.println("GRAMY: " + weight.miligramToGram(Double.valueOf(milligramsString)));
            writer.println("MILIGRAMY: " + weight.miligram(Double.valueOf(milligramsString)));

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
