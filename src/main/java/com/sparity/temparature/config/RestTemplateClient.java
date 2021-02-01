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


	@Value("${TEMP_URL}")
	private transient String tempUrl;
	
	@Value("${WEATHER_APIKEY}")
	private transient String appid;

	public LocationInfo getLocation(String lat,String lon) {
		try {
			RestTemplate restTemplate = new RestTemplate();
			//http://api.openweathermap.org/data/2.5/weather?lat=17.38&lon=78.48&appid=5fef085a318d6ed42d65d6fbf06f7a18
			String path = tempUrl+"?lat="+lat+"&lon="+lon+"&appid="+appid;
			URI url = new URI(path);
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
			if (response != null) {
				JSONObject json = new JSONObject(response.getBody().toString());
				String  name = json.getString("name");
				JSONObject main =(JSONObject)json.get("main");
				Double temp =(Double)main.get("temp");
				JSONObject sys = (JSONObject)json.get("sys");
				String country = sys.getString("country");
				LocationInfo location = new LocationInfo();				
				location.setLon(lon);
				location.setLat(lat);
				location.setCountry(country);
				location.setTemparature(String.valueOf(temp-273.15) );
				location.setName(name);
				return location;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Failed to fetch the location details  :: " + e.getMessage());
		}
		return null;
	}

}