package taxi.controller.authentication;

import java.io.IOException;
import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import taxi.lib.Injector;
import taxi.model.Driver;
import taxi.service.AuthenticationService;

public class LoginController extends HttpServlet {
    private static final Injector injector = Injector.getInstance("taxi");
    private static AuthenticationService authService;

    @Override
    public void init() throws ServletException {
        authService = (AuthenticationService) injector.getInstance(AuthenticationService.class);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/authentication/login.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        try {
            Driver driver = authService.login(login, password);
            HttpSession session = req.getSession();
            session.setAttribute("driver_id", driver.getId());
            resp.sendRedirect(req.getContextPath() + "/index");
        } catch (AuthenticationException e) {
            req.setAttribute("errMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/views/authentication/login.jsp").forward(req, resp);
        }
    }
}
