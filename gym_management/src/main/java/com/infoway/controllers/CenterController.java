package com.infoway.controllers;
import java.util.List;

import com.infoway.services.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.infoway.models.entities.Center;


@CrossOrigin
@RestController
public class CenterController {

	@Autowired
	private CenterService centerService;
	
	@PostMapping("/center")
	Center newCenter(@RequestBody Center newCenter)
	{
		return centerService.save(newCenter);
	}
	
	
	@GetMapping("/getcenters")
	List<Center> getAllCenters()
	{
		return centerService.findAll();
	}

	@GetMapping("/my_centers")
	List<Center> getOwnerCenters(@RequestParam(name = "owner_id") Integer ownerId) {
		return centerService.findMyCenters(ownerId);
	}

//	@GetMapping("/my_centers/{owner_id}")
//	List<Center> getOwnerCenters(@PathVariable("owner_id") Integer ownerId) {
//		return centerService.findMyCenters(ownerId);
//	}

		@GetMapping("/all_centers")
		List<Center> getAllFilteredCenters(@RequestParam(name = "locality") String locality) {
		return centerService.findByLocality(locality);
	}


	@GetMapping("/localities")
	List<String> getAllLocations() {return centerService.findAllLocalities();}



	@PutMapping("/centers/{id}")
	Center updateCenter(@RequestBody Center newCenter, @PathVariable Integer id) {
		Center center = centerService.findById(id);
		center.setName(newCenter.getName());
		center.setDescription(newCenter.getDescription());
		center.setLocality(newCenter.getLocality());
		center.setAddress(newCenter.getAddress());
		center.setContact(newCenter.getContact());
		return centerService.save(center);
	}

	//delete user
	@DeleteMapping("/centers/{id}")
	public void delete(@PathVariable("id") int centerId){
		centerService.deleteById(centerId);
	}

}