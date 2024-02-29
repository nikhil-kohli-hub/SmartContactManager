package com.smart.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;



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
