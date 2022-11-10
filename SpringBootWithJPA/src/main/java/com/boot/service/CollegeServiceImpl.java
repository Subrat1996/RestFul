package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.Repository.CollegeRepository;
import com.boot.model.College;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	private CollegeRepository repo;
	@Override
	public List<College> findAllCollege() {
		return repo.findAll();
	}

	@Override
	public College savecollege(College college) {
		return repo.save(college);
	}

	@Override
	public void deleteById(int cid) {
		 repo.deleteById(cid);
	}

	@Override
	public College findById(int cid) {
		return repo.findById(cid).orElse(null);
	}

	@Override
	public College updateById(College college) {
		return repo.save(college);
	}

}
