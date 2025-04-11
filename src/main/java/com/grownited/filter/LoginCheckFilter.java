package com.grownited.filter;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.grownited.entity.UserEntity;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginCheckFilter implements Filter {
	
	ArrayList<String> publicURL = new ArrayList<>();

    public LoginCheckFilter() {
        publicURL.add("/login");
        publicURL.add("/signup");
        publicURL.add("/saveuser");
        publicURL.add("/forgetpassword");
        publicURL.add("/sendotp");
        publicURL.add("/authenticate");
        publicURL.add("/logout");
        publicURL.add("/updatepassword");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();

        System.out.println("Filter Call...." + uri);

        // Allow public URLs
        if (publicURL.contains(uri) || uri.contains(".css") || uri.contains(".js")
                || uri.contains("dist") || uri.contains("images") ) {
            chain.doFilter(request, response);
            return;
        }

        // Allow AJAX (e.g., /getcity or any API endpoint)
        if (uri.startsWith("/getcity") ) {
            chain.doFilter(request, response);
            return;
        }

        // Check session
        HttpSession session = req.getSession(false);
        UserEntity user = (session != null) ? (UserEntity) session.getAttribute("user") : null;

        if (user == null) {
            req.getRequestDispatcher("/login").forward(request, response);
            return;
        }

        // Role-based access
        if (uri.startsWith("/admin")) {
            if (!user.getRole().equals("ADMIN")) {
                req.getRequestDispatcher("/login").forward(request, response);
                return;
            }
        } else if (!uri.startsWith("/admin") && user.getRole().equals("ADMIN")) {
            req.getRequestDispatcher("/login").forward(request, response);
            return;
        }

        // All checks passed
        chain.doFilter(request, response);
    }
	}

