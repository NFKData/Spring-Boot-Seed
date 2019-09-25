package com.nfkdata.seed.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * Welcome Class for RootResource
 */
@Getter @Setter @RequiredArgsConstructor
public class Welcome implements Serializable {
	
	/**
	 * UID used for serialization
	 */
	private static final long serialVersionUID = 7903699388255289170L;
	
	/**
	 * Field containing text to send
	 */
	@NonNull
	private String text;

}
