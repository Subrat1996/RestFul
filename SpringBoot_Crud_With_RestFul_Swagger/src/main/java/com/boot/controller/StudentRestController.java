package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Student;
import com.boot.service.IStudentService;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	private IStudentService service;

	//1. fetch all Students
	@GetMapping("/all")
	public ResponseEntity<?> fetchAllStudents(){
		ResponseEntity<?> resp=null;
		try {
			List<Student> list=service.findAllStudents();
			resp=new ResponseEntity<List<Student>>(list, HttpStatus.OK);
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to Fetch data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;
	}

	//2. fetch one student by id
	@GetMapping("/one/{id}")
	public ResponseEntity<?> fetchOneStudent(
			@PathVariable("id")Integer id
			)
	{
		ResponseEntity<?> resp=null;
		try {
			Student s=service.findOneStudent(id);
			if(s!=null) { //if student exist
				resp=new ResponseEntity<Student>(s,HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>("No Student exist with id:"+id,HttpStatus.OK);
			}
		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to Fetch data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}

	//3. save student
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(
			@RequestBody Student student
			)
	{
		ResponseEntity<String> resp=null;
		try {
			Integer id=service.saveStudent(student);
			resp=new ResponseEntity<String>("saved with id:"+id,HttpStatus.OK);
			//resp=new ResponseEntity<String>("saved with id:"+id,HttpStatus.CREATED);

		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to save data", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;
	}

	//4. delete one student by id
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteOneStudent(
			@PathVariable("id")Integer id
			)
	{
		ResponseEntity<String> resp=null;
		try {

			boolean exist=service.isStudentExist(id);
			if(exist) {
				service.deleteStudent(id);
				resp=new ResponseEntity<String>("Student Deleted:"+id,HttpStatus.OK);
			}else {
				resp=new ResponseEntity<String>("Student Not exist:"+id,HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to perform Delete", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}

		return resp;
	}

	//5. update one student
	@PutMapping("/update")
	public ResponseEntity<String> updateStudent(
			@RequestBody Student student
			)
	{
		ResponseEntity<String> resp=null;

		try {

			Integer stdId=student.getStdId();
			//check student exist or not? with given msg
			boolean exist=service.isStudentExist(stdId);

			if(exist) { //if student exist in DB
				service.updateStudent(student);
				resp = new ResponseEntity<String>("Student Updated!", HttpStatus.OK);
				//resp = new ResponseEntity<String>("Student Updated!", HttpStatus.RESET_CONTENT);
			}else {
				resp = new ResponseEntity<String>("Student Not exist:"+stdId, HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			resp=new ResponseEntity<String>("Unable to Update Student!", HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
}
