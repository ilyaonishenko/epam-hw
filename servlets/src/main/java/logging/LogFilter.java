package logging;

import lombok.extern.java.Log;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by wopqw on 24.10.16.
 */

@Log
@WebFilter("/*")
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest)request;
        String s = httpRequest.getRequestURI();
        log.info("someone want's to get to "+ s);
        chain.doFilter(request, response);
        log.info("someone is in "+ s);
    }
}
