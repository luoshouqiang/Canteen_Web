package com.canteen.manage.utils;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	public static String getJsonValue(String rescontent, String key) {
		ObjectMapper mapper =new ObjectMapper();
		Map<String,String> map =null;
		String v = null;
		try {
			map=mapper.readValue(rescontent, new TypeReference<Map<String,String>>(){});
			v=map.get(key);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return v;
	}
	
	public static <T>  T jsonToObject(String json,Class<T> className) {
		ObjectMapper mapper =new ObjectMapper();
		T obj=null;
		try {
			obj=mapper.readValue(json, className);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return obj;
	}
	
	public static String objToJson(Object obj){
		try{
		ObjectMapper mapper =new ObjectMapper();
		return mapper.writeValueAsString(obj);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "";
	}
}
