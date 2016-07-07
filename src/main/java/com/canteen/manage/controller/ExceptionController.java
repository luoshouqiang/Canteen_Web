package com.canteen.manage.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.canteen.manage.ex.BusinessException;
import com.canteen.manage.utils.ReturnJson;

@ControllerAdvice(basePackages={"com.canteen.manage.controller"})
public class ExceptionController {
	
	    @ExceptionHandler(BusinessException.class)
	    @ResponseBody
	    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
	    	ex.printStackTrace();
	        HttpStatus status = HttpStatus.BAD_REQUEST;
	        HttpHeaders headers =new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	        ReturnJson<Void> returnJson=new ReturnJson<Void>(401, ex.getMessage());
	        return new ResponseEntity<ReturnJson<Void>>(returnJson,headers, status);
	    }
	    
	    @ExceptionHandler(Exception.class)
	    @ResponseBody
	    ResponseEntity<?> handleInternalServerException(HttpServletRequest request, Throwable ex) {
	    	ex.printStackTrace();
	        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
	        HttpHeaders headers =new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
	        ReturnJson<Void> returnJson=new ReturnJson<Void>(500, "系统异常");
	        return new ResponseEntity<ReturnJson<Void>>(returnJson,headers, status);
	    }

	  
	
}
