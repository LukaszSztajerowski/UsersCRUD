package UserCRUD;

import UserDAO.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/list")
public class MainPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    UserDAO userDAO = new UserDAO();
    User[] users = userDAO.findAll();

    req.setAttribute("users", users);

    getServletContext().getRequestDispatcher("/jsp/mainPage.jsp").forward(req, resp);

    }
}
