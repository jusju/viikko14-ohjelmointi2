package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/christmas")
public class Christmas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        LocalDate dateBefore = LocalDate.now();
        LocalDate dateAfter = LocalDate.parse("2020-12-24");
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(dateBefore, dateAfter);

        // lähetetään aika merkkijono JSP-sivulle attribuuttina
        req.setAttribute("aikaEro", daysBetween);

        // lähetä request edelleen index.jsp sivulle
        req.getRequestDispatcher("/WEB-INF/christmas.jsp").forward(req, resp);
    }
}
