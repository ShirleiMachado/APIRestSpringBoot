package com.vacinas.restApi.Controller;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ErrosApi {

	
	@Getter
	private List<String> erros;
	
	public ErrosApi(List<String> erros) {
		this.erros = erros;
	}
	
	public ErrosApi(String message) {
		
		this.erros = Arrays.asList(message);
	}
	
}
