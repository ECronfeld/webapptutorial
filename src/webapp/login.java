package webapp;

import appLayer.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/login")
public class login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("doPost-version");
        out.println("login name" + request.getParameter("loginname") + "Password" + request.getParameter("password"));

        User userobject = new User();


        request.setAttribute("username",request.getParameter("loginname"));
        request.setAttribute("password",request.getParameter("password"));
        if(userobject.isValidUSerCredentials(request.getParameter("loginname"), request.getParameter("password"))){
            request.getRequestDispatcher("/welcome.jsp").forward(request,response);
        }   else {
            request.setAttribute("Errormessage", "invalid username or password");
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("login name" + request.getParameter("loginname") + "Password" + request.getParameter("password"));
        out.println("doGet-version");
    }
}
