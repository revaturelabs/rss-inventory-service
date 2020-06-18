package com.revature.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.inventory.model.Manufacturer;

@Repository
public interface ManufacturerDao extends JpaRepository<Manufacturer, Long> {

}
