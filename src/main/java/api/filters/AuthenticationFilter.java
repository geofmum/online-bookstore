package api.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class AuthenticationFilter implements javax.servlet.Filter {
    protected String Method = "GET";
    protected Map<String, ArrayList<String>> restrictedRoutes = new HashMap<String, ArrayList<String>>(){{
        put("GET", new ArrayList<String>(){{
            add("/cart");
        }});
        put("POST", new ArrayList<String>());
        put("PUT", new ArrayList<String>(){{
            add("/cart");
        }});
        put("DELETE", new ArrayList<String>());
        put("ALL", new ArrayList<String>());
    }};

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();

        Method = request.getMethod().toUpperCase();

        if (!isRestrictedRoute(getRequestUrl(request)) || isAuthenticated(session)) {
            chain.doFilter(req, resp);
        } else {
            if (Arrays.binarySearch(new String[]{"PUT", "DELETE"}, Method) >= 0 ) {
                response.setStatus(401);
            } else {
                response.sendRedirect("/login");
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

    protected boolean isAuthenticated(HttpSession session) {
        return session != null && session.getAttribute("userid") != null;
    }

    protected String getRequestUrl(HttpServletRequest req) {
        String url = req.getRequestURI().substring(req.getContextPath().length());
        return url;
    }

    protected boolean isRestrictedRoute(String route) {
        List<String> _restrictedRoutes = restrictedRoutes.get(Method);

        return _restrictedRoutes.contains(route) || restrictedRoutes.get("ALL").contains(route);
    }
}