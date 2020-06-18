package com.revature.inventory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.inventory.model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {

}
