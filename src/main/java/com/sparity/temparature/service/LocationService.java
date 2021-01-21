package com.sparity.temparature.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

	
	public Location saveLocation(Location location,HttpServletRequest request) {			
		Location loc = locationRepository.findByLonAndLat(location.getLon(),location.getLat());
		if(loc != null) {
			//location.setTemparature(loc.getTemparature());
			return loc;
		}else {
			LocationInfo locationInfo = client.getLocation(request);
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
	public Location getLocationByLongitudeAndLatitude(String longitude,String latitude) {
		Location location = locationRepository.findByLonAndLat(longitude,latitude);
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