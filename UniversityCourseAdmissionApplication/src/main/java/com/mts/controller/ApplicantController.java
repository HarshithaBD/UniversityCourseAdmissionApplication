package com.mts.controller;

import java.util.List;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
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

import com.mts.dto.ApplicantDto;
import com.mts.entity.AdmissionStatus;
import com.mts.entity.Applicant;
import com.mts.exception.ApplicantNotFoundException;
import com.mts.service.IApplicantService;

@RestController
@RequestMapping("/applicant")
public class ApplicantController {
	

	@Autowired
	IApplicantService service;
	//add applicant
	@PostMapping
	public ResponseEntity<Applicant> addApplicant(@RequestBody Applicant applicant) {
		Applicant applicant1=service.addApplicant(applicant);
		return new ResponseEntity<>(applicant1,HttpStatus.OK);
}
	//update applicant
	@PutMapping
	public ResponseEntity<Object> updateApplicant(@RequestBody Applicant applicant) {
		try {
			Applicant applicant1=service.updateApplicant(applicant);
			return new ResponseEntity<>(applicant1,HttpStatus.OK);
		}
		catch(ApplicantNotFoundException e)
		{
		return ResponseEntity.ok().body(e.getMessage());
	}
	}
	
	//delete mapping
	@DeleteMapping
	public ResponseEntity<String>  deleteApplicant(@RequestBody Applicant applicant)
	{
		try {
			service.deleteApplicant(applicant);
			return ResponseEntity.ok("Deleted");
		}
		catch(ApplicantNotFoundException e) {
			return  new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	//view applicant
	@GetMapping("/viewApplicant/{applicantId}")
	public ResponseEntity<Object>  viewApplicant(@PathVariable int applicantId) {
		try {
			ApplicantDto applicant1=service.viewApplicant(applicantId);
			return new ResponseEntity<>(applicant1,HttpStatus.OK);
		}catch(ApplicantNotFoundException e) {
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	}
	
	//view all applicantstatus
	@GetMapping("/viewAllApplicantsByStatus/{status}")
	public ResponseEntity<List<ApplicantDto>> viewAllApplicantsByStatus(@PathVariable AdmissionStatus status){
		List<ApplicantDto> lst=service.viewAllApplicantsByStatus(status);

		return new ResponseEntity<>(lst,HttpStatus.OK);
	}
}