package com.sparity.temparature.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sparity.temparature.config.RestTemplateClient;
import com.sparity.temparature.dto.LocationInfo;
import com.sparity.temparature.model.Location;
import com.sparity.temparature.repository.LocationRepository;
import com.sparity.temparature.util.CommonUtils;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	@Autowired
	private RestTemplateClient client;
	

	
	public Location saveLocation(Location location) {		
		Location loc = locationRepository.findByLonAndLat(location.getLon(),location.getLat());
		if(loc != null) {
			return loc;
		}else {
			LocationInfo locationInfo = client.getLocation(location.getLat(),location.getLon());
			if(locationInfo != null) {
				CommonUtils.copyNonNullProperties(locationInfo, location);
			}
		}	
		return locationRepository.save(location);
	}
	public Location updateLocation(Location location) {	
		Location loc = locationRepository.findByLonAndLat(location.getLon(),location.getLat());
		if(loc != null) {
			location.setEntityId(loc.getEntityId());
			CommonUtils.copyNonNullProperties(location, loc);
		}	
		return locationRepository.save(loc);
	}
	public Object getLocationByLongitudeAndLatitude(String longitude,String latitude) {
		Location location = locationRepository.findByLonAndLat(longitude,latitude);
		if(location == null) {
			Map<String,String> keyValue = new HashMap<String,String>();
			keyValue.put("message", "no data");
			return new ResponseEntity<Object>(keyValue,HttpStatus.EXPECTATION_FAILED);
		}
		return location;
	}
	
	public Location deleteLocationByLongitudeAndLatitude(String longitude,String latitude) {
		Location location = locationRepository.findByLonAndLat(longitude,latitude);
		if(location != null ) {
			locationRepository.deleteById(location.getEntityId());
		}		
		return location;
	}
	public Location deleteLocation(Long id) {
		Optional<Location> location = locationRepository.findById(id);
		locationRepository.deleteById(id);
		return location.get();
	}
	
	public Location getLocationById(Long id) {
		Optional<Location> location = locationRepository.findById(id);
		return location.get();
	}
	public List<Location> getLocations() {
		return (List<Location>) locationRepository.findAll();
	}
	
}