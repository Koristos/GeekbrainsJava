package ru.geekbrains.SpringLessonOne;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Object login = session.getAttribute("login");
        if (login==null){
            login = req.getParameter("login");
            if (login!=null&&isValid(login)){
                session.setAttribute("login",login);
            }else {
                res.sendError(401,"You are not authorised!");
            }
        }
        super.doFilter(req, res, chain);
    }

    private boolean isValid (Object login){
        return login.equals("user");
    }
}
