package com.smart.services;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Component
public class SessionHelper {
	
	public void removeMessageFromSession() {
		try {
			HttpSession session = ((HttpServletRequest) RequestContextHolder.getRequestAttributes()).getSession();
			session.removeAttribute("message");
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}