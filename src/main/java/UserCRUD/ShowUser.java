package UserCRUD;

import UserDAO.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/show")
public class ShowUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String email = req.getParameter("email");
//        String id = req.getParameter("id");
//
//        resp.getWriter().println(id + " " + username + " " +email);

        int id = Integer.parseInt(req.getParameter("id"));
        UserDAO userDAO = new UserDAO();
        User user = userDAO.read(id);

        req.setAttribute("user", user);

        getServletContext().getRequestDispatcher("/jsp/show.jsp").forward(req, resp);

    }
}
