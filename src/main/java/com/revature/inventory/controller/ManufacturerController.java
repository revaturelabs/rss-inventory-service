package com.revature.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.inventory.dao.ManufacturerDao;
import com.revature.inventory.model.Manufacturer;

@CrossOrigin
@RestController
public class ManufacturerController {
	
	private final ManufacturerDao manufacturerDao;
	
	
	@Autowired
	public ManufacturerController(ManufacturerDao manufacturerDao) {
		super();
		this.manufacturerDao = manufacturerDao;
	}


	@GetMapping("/manufacturer/{id}")
	public java.util.Optional<Manufacturer> getManufacturerById(@PathVariable Long id) {
		return manufacturerDao.findById(id);
	}

	@GetMapping("/manufacturer")
	public List<Manufacturer> getAllManufacturer() {
		return manufacturerDao.findAll();
	}

	@PostMapping("/manufacturer")
	public Manufacturer createManufacturerById(@RequestBody Manufacturer manufacturer) {
		return manufacturerDao.save(manufacturer);
	}


	@PutMapping("/manufacturer")
	public Manufacturer updateManufacturer(@RequestBody Manufacturer manufacturer) {
		return manufacturerDao.save(manufacturer);
	}

	@DeleteMapping("/manufacturer/{id}")
	public void deleteManufacturerById(@PathVariable Long id) {
		manufacturerDao.deleteById(id);
	}
}
