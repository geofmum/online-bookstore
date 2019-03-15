package api.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

public class AuthenticationFilter implements javax.servlet.Filter {
    protected String[] unrestrictedRoutes = {"/", "/login", "/logout"};

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();

        if (!isRestrictedRoute(getRequestUrl(request)) || isAuthenticated(session)) {
            chain.doFilter(req, resp);
        } else {
            request.getRequestDispatcher("views/login.jsp").forward(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

    protected boolean isAuthenticated(HttpSession session) {
        return session != null && session.getAttribute("userid") != null;
    }

    protected String getRequestUrl(HttpServletRequest req) {
        String url = req.getRequestURL().toString();

        return url;
    }

    protected boolean isRestrictedRoute(String route) {
        int index = Arrays.binarySearch(unrestrictedRoutes, route);

        return index >= 0;
    }
}