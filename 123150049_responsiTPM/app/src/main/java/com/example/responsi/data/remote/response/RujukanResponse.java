package com.example.responsi.data.remote.response;

import java.util.List;

import com.example.responsi.data.model.Rujukan;
import com.google.gson.annotations.SerializedName;

public class RujukanResponse {

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private List<Rujukan> rujukanList;

	public int getStatusCode(){
		return statusCode;
	}

	public List<Rujukan> getrujukanList(){
		return rujukanList;
	}
}