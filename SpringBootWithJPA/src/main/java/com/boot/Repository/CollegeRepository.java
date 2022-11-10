package com.boot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.model.College;

public interface CollegeRepository extends JpaRepository<College,Integer> {

	

}
