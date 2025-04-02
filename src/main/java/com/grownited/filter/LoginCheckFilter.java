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
		HttpServletRequest requestHttp = (HttpServletRequest) request;
		String url = requestHttp.getRequestURI().toString();
		String uri = requestHttp.getRequestURI();
 
		
		System.out.println("Filter Call...." + uri);

		if (publicURL.contains(uri) || uri.contains(".css") || uri.contains(".js") || uri.contains("dist")
				|| uri.contains("images")) {
			chain.doFilter(requestHttp, response);
		} else {
			HttpSession session = requestHttp.getSession();
			UserEntity user = (UserEntity) session.getAttribute("user");

			if (user == null) {
				requestHttp.getRequestDispatcher("login").forward(request, response);
			} else {
				if (uri.startsWith("/admin")) {
					if (user.getRole().equals("ADMIN")) {
						chain.doFilter(request, response);
					}else {
						requestHttp.getRequestDispatcher("login").forward(request, response);
					}
				} else {
					chain.doFilter(request, response);
				}
			}
		}
	}
}
