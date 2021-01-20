package com.sparity.temparature.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sparity.temparature.model.Location;
import com.sparity.temparature.service.LocationService;

@RestController
@RequestMapping(value="/api/location")
public class LocationController {
	

	@Autowired
	private LocationService service;
	
	@PostMapping
	private Location saveLocation(@RequestBody Location location,HttpServletRequest request){
		return service.saveLocation(location,request);
	}
	@GetMapping
	private Location getLocationByLongitudeAndLatitude(@RequestParam(value ="longitude")String longitude,@RequestParam(value ="latitude")String latitude){
		return service.getLocationByLongitudeAndLatitude(longitude,latitude);
	}
	@DeleteMapping
	private Location deleteLocationByLongitudeAndLatitude(@RequestParam(value ="longitude")String longitude,@RequestParam(value ="latitude")String latitude){
		return service.deleteLocationByLongitudeAndLatitude(longitude,latitude);
	}
	@PutMapping
	private Location updateLocationByLongitudeAndLatitude(@RequestBody Location location){
		return service.updateLocation(location);
	}
	
	/*@GetMapping
	private List<Location> getAllLocations(){
		return service.getLocations();
	}

	@GetMapping("/{id}")
	private Location getLocationById(@PathVariable Long id){
		return service.getLocationById(id);
	}
	*/
	
	@DeleteMapping("/{id}")
	private Location deleteLocation(@PathVariable Long id){
		return service.deleteLocation(id);
	}

	

}
