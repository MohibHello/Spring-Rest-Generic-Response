package com.muhib.restresponse.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {

	private boolean error;
	private int status;
	private String message;
	private Object data;
}
