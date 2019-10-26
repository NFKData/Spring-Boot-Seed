package com.nfkdata.seed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "${package.to.scan.rest}, ${package.to.scan.domain}",
		"${package.to.scan.service}", "${package.to.scan.interceptor}", "${package.to.scan.config}" })
public class SpringBootApplicationLauncher {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationLauncher.class, args);
	}

}
