package com.canteen.manage.utils;



public class ReturnJson<T> {

	private int code=200;
	
	private String msg;
	
	private T data;
	
	public ReturnJson(){}
	
	public ReturnJson(int code,String msg){
		this.code=code;
		this.msg=msg;
	}
	
	public ReturnJson(int code,String msg,T data){
		this.code=code;
		this.msg=msg;
		this.data=data;
	}
	
	public ReturnJson(T data){
		this.data=data;
	}

	public int getCode() {
		return code;
	}



	public void setCode(int code) {
		this.code = code;
	}



	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	

	
}
