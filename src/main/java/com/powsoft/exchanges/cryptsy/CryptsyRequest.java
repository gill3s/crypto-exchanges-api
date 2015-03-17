package com.powsoft.exchanges.cryptsy;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.powsoft.exchanges.cryptsy.utils.ParseUtils;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

/**
 * 
 * @author opsun
 * @since 1.0, 2014-6-5
 */
public abstract class CryptsyRequest<T> {
	
	//the response Class 
	private Class<T> clazz ;
	
	@SuppressWarnings("unchecked")
	public CryptsyRequest() {
		this.clazz = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public Class<T> getResponseClass(){
		return clazz;
	}
	
	/**
	 * the api method
	 * @return
	 */
	public abstract String getMethod();
	
	/**
	 * the input parameters
	 * @return
	 */
	public Map<String, String> getParams(){
		return null;
	}
	
	/**
	 * validate the parameters
	 * @return
	 */
	public boolean check(){
		return true;
	}
	
	/**
	 * Whether to authorize
	 * @return
	 */
	public boolean auth(){
		return true;
	}
	
	/**
	 * parse the json to java bean
	 * @param json
	 * @return
	 */
	public T parse(JsonNode json){
		
		//special handling array
		if(json instanceof ArrayNode){
			json = ParseUtils.pack(json, "return");
		}
		
		return ParseUtils.convertValue(json, clazz);
	}
	
}
