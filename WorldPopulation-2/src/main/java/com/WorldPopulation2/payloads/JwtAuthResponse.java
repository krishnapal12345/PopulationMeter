package com.WorldPopulation2.payloads;

import lombok.Data;

@Data
public class JwtAuthResponse {

	private String Token;
	private String role;
}
