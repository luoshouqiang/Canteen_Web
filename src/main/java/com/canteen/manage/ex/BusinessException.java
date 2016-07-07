package com.canteen.manage.ex;

/**
 * 自定义异常
 * @author luosq
 *
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private int code;
	private String errorMessage;

	public BusinessException(int code, String errorMessage) {
		super(errorMessage);
		this.code = code;
		this.errorMessage = errorMessage;
	}

	public BusinessException(int code) {
		this.code = code;
	}
	public BusinessException(int code, Throwable cause) {
		super(cause);
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
