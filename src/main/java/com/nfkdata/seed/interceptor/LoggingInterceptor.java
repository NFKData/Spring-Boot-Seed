package com.nfkdata.seed.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.nfkdata.seed.service.LoggingService;
import com.nfkdata.seed.service.RequestService;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

	@Autowired
	private RequestService requestService;
	
	@Autowired
	private LoggingService loggingService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		loggingService.info("Processing request of: {0}", requestService.resolvePathAndQuery(request));
		loggingService.debug("Request headers: \n{0}", requestService.formatHeaders(request));
		loggingService.debug("Request body: \n{0}", requestService.getBody(request));
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		loggingService.info("Returning response of: {0}", requestService.resolvePathAndQuery(request));
		loggingService.debug("Response headers: \n{0}", requestService.formatHeaders(request));
	}
}
