package org.example.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class LoginCheck implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Check if user is logged in (this can vary based on your authentication method)
        HttpSession session = httpRequest.getSession(false); // Get the session, but do not create one if it doesn't exist
        boolean loggedIn = (session != null && session.getAttribute("user") != null);

        // List of protected URLs (adjust based on your application)
        String loginURI = httpRequest.getContextPath() + "/login";
        String loginURL = httpRequest.getContextPath() + "/login.jsp";
        String requestedURI = httpRequest.getRequestURI();
        String registerURI = httpRequest.getContextPath() + "/register";
        String registerURL = httpRequest.getContextPath() + "/register.jsp";

        if (!loggedIn && !requestedURI.equals(loginURI) && !requestedURI.equals(registerURI)) {
            httpResponse.sendRedirect(loginURI); // Redirect to login page
        } else if(loggedIn && (requestedURI.equals(loginURI) || requestedURI.equals(registerURI) || requestedURI.equals(loginURL) || requestedURI.equals(registerURL))) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/prodman");
        }
        else {
            chain.doFilter(request, response);
        }
    }
}
