package com.boot.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.StudentRepo;
import com.boot.entity.Students;

import jakarta.servlet.http.HttpServletRequest;


@Service
public class StudentService {

	@Autowired
	public StudentRepo repo;
	
	public String launchRegisterStudent() {
		
		return "RegisterStudent.html";
	}
	
	public String registerStudent(HttpServletRequest req) {
		
		Students stud= new Students();
		
		stud.setUserName(req.getParameter("uname"));
		stud.setPassword(req.getParameter("pass"));
		stud.setUserType(req.getParameter("usertype"));
		stud.setStudName(req.getParameter("name"));
		stud.setStudentId(Integer.parseInt(req.getParameter("id")));
		
		repo.save(stud);
		
		return"login.html";
	}
}
