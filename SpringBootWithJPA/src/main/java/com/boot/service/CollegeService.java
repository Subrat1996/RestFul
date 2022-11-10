package com.boot.service;

import java.util.List;

import com.boot.model.College;

public interface CollegeService {

	public List<College> findAllCollege();

	public College savecollege(College college);

	public void deleteById(int cid);

	public College findById(int cid);

	public College updateById(College college);

}
