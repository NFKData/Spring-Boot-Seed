package com.nfkdata.seed.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {
	
	@Autowired
	private LoggingService loggingService;

	public String formatHeaders(HttpServletRequest request) {
		StringBuilder headers = new StringBuilder();
		request.getHeaderNames().asIterator().forEachRemaining(headerName -> {
			headers.append("\t");
			headers.append(headerName);
			headers.append(": ");
			headers.append(request.getHeader(headerName));
			headers.append('\n');
		});
		return headers.toString();
	}

	public String formatHeaders(HttpServletResponse response) {
		StringBuilder headers = new StringBuilder();
		response.getHeaderNames().iterator().forEachRemaining(headerName -> {
			headers.append('\t');
			headers.append(headerName);
			headers.append(": ");
			headers.append(response.getHeader(headerName));
			headers.append('\n');
		});
		return headers.toString();
	}

	public String resolvePathAndQuery(HttpServletRequest request) {
		StringBuilder pathAndQuery = new StringBuilder(Optional.ofNullable(request.getPathTranslated()).orElse("/"));
		pathAndQuery.append(Optional.ofNullable(request.getQueryString()).orElse("?"));
		return pathAndQuery.toString();
	}

	public String getBody(HttpServletRequest request) {
		StringBuilder body = new StringBuilder();
		try (BufferedReader bodyReader = request.getReader()) {
			while (bodyReader.ready()) {
				body.append(bodyReader.readLine());
				body.append('\n');
			}
		} catch (IOException e) {
			loggingService.error("Error reading the request body", e);
			body.append("###ERR###NO_MORE_READABLE_CONTENT###ERR###");
		}
		return body.toString();
	}
}
