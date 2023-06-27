import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CalcularIMC extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String nombre = request.getParameter("nombre");
        double peso = Double.parseDouble(request.getParameter("peso"));
        double estatura = Double.parseDouble(request.getParameter("estatura"));

        double imc = peso / (estatura * estatura);

        String categoria;
        if (imc < 18.5) {
            categoria = "Peso bajo";
        } else if (imc >= 18.5 && imc <= 24.9) {
            categoria = "Peso Normal";
        } else if (imc >= 25.0 && imc <= 29.9) {
            categoria = "Peso alto";
        } else {
            categoria = "Obesidad";
        }

        out.println("<html><head>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; }");
        out.println("p { padding: 10px; border: 1px solid #ddd; border-radius: 5px; }");
        out.println("a.button { display: inline-block; padding: 10px; background-color: #007BFF; color: #fff; border-radius: 5px; text-decoration: none; }");
        out.println("a.button:hover { background-color: #0056b3; }");
        out.println("</style>");
        out.println("</head><body>");
        out.println("<p>Nombre: " + nombre + "</p>");
        out.println("<p>Peso: " + peso + "</p>");
        out.println("<p>Estatura: " + estatura + "</p>");
        out.println("<p>Su índice de masa corporal es " + imc + ". Usted se encuentra en " + categoria + ".</p>");
        out.println("<a href=\"index.html\" class=\"button\">Calcular IMC para otra persona</a>");
        out.println("</body></html>");
    }
}

