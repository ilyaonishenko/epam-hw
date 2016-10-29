package filters;

import DAO.GunDAO;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wopqw on 28.10.16.
 */
public class ShowRoomFilter implements HttpFilter {

    private GunDAO gunDAO;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        gunDAO = (GunDAO) filterConfig.getServletContext()
                .getAttribute("gunDAO");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

    }
}
