package com.sparity.temparature.config;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sparity.temparature.dto.Current;
import com.sparity.temparature.dto.LocationInfo;
import com.sparity.temparature.model.Location;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RestTemplateClient {

	private static final String IPHEADER = "X-Forwarded-For";

	@Value("${WEATHER_URL}")
	private transient String weatherUrl;

	public LocationInfo getLocation(HttpServletRequest request) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			String remoteAddr = request.getHeader(IPHEADER);
			String path = null;
			if (StringUtils.isBlank(remoteAddr)) {
				remoteAddr = request.getRemoteAddr();

			}
			if (StringUtils.isNotBlank(remoteAddr) && remoteAddr.equals("0:0:0:0:0:0:0:1")) {
				ResponseEntity<String> ipAddress = restTemplate.getForEntity("https://ipv4.icanhazip.com/",
						String.class);
				remoteAddr = ipAddress.getBody().toString().trim();
			}
			path = weatherUrl + "?ip=" + remoteAddr;

			URI url = new URI(path);
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
			if (response != null) {
				JSONObject json = new JSONObject(response.getBody().toString());
				Gson g = new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm").create();
				Current current = g.fromJson(json.optString("current").toString(), Current.class);
				LocationInfo location = g.fromJson(json.optString("location").toString(), LocationInfo.class);
				location.setTemparature(current.getTemperature());
				return location;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Failed to fetch the location details  :: " + e.getMessage());
		}
		return null;
	}

}