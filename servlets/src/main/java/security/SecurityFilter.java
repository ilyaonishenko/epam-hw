package security;

import DAO.PersonDAO;
import filters.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * Created by wopqw on 24.10.16.
 */

@WebFilter("/*")
public class SecurityFilter implements HttpFilter {

    @SuppressWarnings("FieldCanBeLocal")
    private static String KEY = "KEY";

    private PersonDAO personDAO;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        personDAO = (PersonDAO)filterConfig.getServletContext().getAttribute("personDAO");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = request.getSession(true);

        if(session.getAttribute(KEY)!=null)
            chain.doFilter(request,response);

        Map<String, String[]> parameterMap = request.getParameterMap();

        if(parameterMap.containsKey("j_password") && parameterMap.containsKey("j_username")){

            try {


                if(authorize(parameterMap)) {

                    session.setAttribute(KEY,new Object());
                    chain.doFilter(request, response);
                }
                else {
                    request.getRequestDispatcher("/error.html").forward(request,response);
                }


            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

        } else {

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.html");
            requestDispatcher.forward(request,response);
        }
    }

    private boolean authorize(Map<String, String[]> parameterMap) throws NoSuchAlgorithmException {

        String login = parameterMap.get("j_username")[0];
        String password = parameterMap.get("j_password")[0];
        String hash = StringEncryptUtil.encrypt(password);

        return personDAO.isRegistred(login,hash);
    }
}
