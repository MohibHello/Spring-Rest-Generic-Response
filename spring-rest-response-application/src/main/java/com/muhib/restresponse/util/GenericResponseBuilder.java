package com.muhib.restresponse.util;

public class GenericResponseBuilder {

	private GenericResponseBuilder() {
	}

	private static final int SUCCESS_STATUS_CODE = 201;
	private static final int FAILURE_STATUS_CODE = 401;
	private static final int EXCEPTION_STATUS_CODE = 501;

	private static final String SUCCESS_MESSAGE = "Success";
	private static final String FAILURE_MESSAGE = "Failure";
	private static final String EXCEPTION_MESSAGE = "Exception";

	public static GenericResponse buildSuccess(Object data) {
		return GenericResponse.builder().error(false).status(SUCCESS_STATUS_CODE).message(SUCCESS_MESSAGE).data(data)
				.build();
	}

	public static GenericResponse buildFailure(Object data) {
		return GenericResponse.builder().error(false).status(FAILURE_STATUS_CODE).message(FAILURE_MESSAGE).data(data)
				.build();
	}

	public static GenericResponse buildException(Object data) {
		return GenericResponse.builder().error(true).status(EXCEPTION_STATUS_CODE).message(EXCEPTION_MESSAGE).data(data)
				.build();
	}
}
