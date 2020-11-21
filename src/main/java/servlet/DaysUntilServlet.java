package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.time.temporal.ChronoUnit.DAYS;

@WebServlet("/daysUntil")
public class DaysUntilServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        LocalDate dateBefore = LocalDate.now();
        
        String year = req.getParameter("year");
        String month = req.getParameter("month");
        String day = req.getParameter("day");
        if(month.length() == 1) {
        	month = "0" + month;
        }
        if(day.length() == 1) {
        	day = "0" + day;
        }
             
        LocalDate dateAfter = LocalDate.parse(year + "-" + month + "-" + day);
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(dateBefore, dateAfter);

        // lähetetään aika merkkijono JSP-sivulle attribuuttina
        req.setAttribute("aikaEro", daysBetween);

        // lähetetään tulevaisuuden-aika merkkijono JSP-sivulle attribuuttina
        req.setAttribute("tulevaisuus", year + "-" + month + "-" + day);
        
        // lähetä request edelleen index.jsp sivulle
        req.getRequestDispatcher("/WEB-INF/timeuntil.jsp").forward(req, resp);
    }
}

