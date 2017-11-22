package com.boot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=false)
public class Country {
	
	@JsonProperty
	private RestResponse RestResponse;

	/*public RestResponse getRestResponse() {
		return RestResponse;
	}

	public void setRestResponse(RestResponse RestResponse) {
		this.RestResponse = RestResponse;
	}*/

	@Override
	public String toString() {
		return "Country [RestResponse = " + RestResponse + "]";
	}
	
	
	

}
