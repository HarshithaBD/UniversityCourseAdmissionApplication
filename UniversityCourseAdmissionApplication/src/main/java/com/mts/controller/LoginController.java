package com.mts.controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mts.exception.AdmissionMemNotFoundException;
import com.mts.exception.ApplicantNotFoundException;
import com.mts.exception.StaffMemberNotFoundException;
import com.mts.service.ILoginService;

@RestController
@RequestMapping("/login")

public class LoginController {
	Log logger = LogFactory.getLog(LoginController.class);
		@Autowired
		ILoginService service;
		
		
		// validate  using applicant
		@GetMapping("/validateApplicant")
		public ResponseEntity<Object> loginAsApplicant(int applicantId, String password) {
			try {
				service.loginAsApplicant(applicantId,password);
				return ResponseEntity.ok("Login Validated");
			}catch(ApplicantNotFoundException e) {
			return ResponseEntity.ok().body(e.getMessage());
		}
		}
		//validate commiteemember
		@GetMapping("/validateCommiteeMember")
		public ResponseEntity<Object> loginAsAdmissionCommiteeMember(int adminId, String password){
			
			try{
				service.loginAsAdmissionCommiteeMember(adminId, password);
				return ResponseEntity.ok("Login validated");
			}
			catch(AdmissionMemNotFoundException e) {
				return ResponseEntity.ok().body(e.getMessage());
				
			}
		}
		//validate staffmember
		
		@GetMapping("/validateStaffMember")
		public ResponseEntity<Object> loginAsUniversityStaffMember(int staffId, String password){
			try {
				 service.loginAsUniversityStaffMember(staffId, password);
				 return ResponseEntity.ok("Login validated");
			}
			catch(StaffMemberNotFoundException e){
				return ResponseEntity.ok().body(e.getMessage());
				
			}
			
		}
	}

