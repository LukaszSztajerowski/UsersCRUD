package UserCRUD;

import UserDAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/delete")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        userDAO.delete(Integer.parseInt(req.getParameter("id")));
        resp.sendRedirect("/user/list");
    }
}
//usuwać powinna metoda doPost
//zmienic nazwę wszystkich klas Servletowych na NazwaKlasyServlet