package com.sparity.temparature.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class LocationInfo {

	private String country;
	private String lat;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-dd-MM hh:mm")
	private Date localtime;
	private String lon;
	private String name;
	private String region;
	private String timezone_id;
	private String utc_offset;
	private String temparature;

}
