package com.nfkdata.seed.service;

import java.text.MessageFormat;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class LoggingService {

	public void info(String toLog, Object... args) {
		Arrays.stream(MessageFormat.format(toLog, args).split("\n")).forEach(line -> log.info(line));
	}
	
	public void debug(String toLog, Object... args) {
		Arrays.stream(MessageFormat.format(toLog, args).split("\n")).forEach(line -> log.debug(line));
	}
	
	public void error(String toLog, Throwable t, Object... args) {
		Arrays.stream(MessageFormat.format(toLog, args).split("\n")).forEach(line -> log.error(line, t));
	}
	
}
