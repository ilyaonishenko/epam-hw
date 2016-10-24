package logging;

import lombok.extern.java.Log;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by wopqw on 24.10.16.
 */

@Log
@WebFilter("/userspace/")
public class LogFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.info("in method doGet");
        chain.doFilter(request, response);
        log.info("out method doGet");
    }
}
