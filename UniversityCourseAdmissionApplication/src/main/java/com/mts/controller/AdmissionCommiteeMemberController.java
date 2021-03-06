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

import com.mts.dto.AdmissionCommiteeMemberDto;
import com.mts.entity.AdmissionCommiteeMember;
import com.mts.entity.AdmissionStatus;
import com.mts.entity.Applicant;
import com.mts.exception.AdmissionMemNotFoundException;
import com.mts.service.IAdmissionCommiteeMemberService;

@RestController
	@RequestMapping("/commitee")
	public class AdmissionCommiteeMemberController {
	
	Log logger = LogFactory.getLog(AdmissionCommiteeMemberController.class);

		@Autowired
		IAdmissionCommiteeMemberService service;
		@PostMapping("/addCommitee")
		public ResponseEntity<AdmissionCommiteeMember> addCommiteeMember(@RequestBody AdmissionCommiteeMember member) {
			AdmissionCommiteeMember m1=service.addCommiteeMember(member);
			return new ResponseEntity<>(m1,HttpStatus.OK);
		}
		
		@PutMapping("/updateCommitee")
		public ResponseEntity<Object> updateCommiteeMember(@RequestBody AdmissionCommiteeMember member) throws AdmissionMemNotFoundException {
			try {
				AdmissionCommiteeMember m1=service.updateCommiteeMember(member);
				return new ResponseEntity<>(m1,HttpStatus.OK);
			}
			catch(AdmissionMemNotFoundException e)
			{
				return ResponseEntity.ok().body(e.getMessage());
				
			}
			
		}
		
		@GetMapping("/viewCommitee/{adminId}")
		public  ResponseEntity<Object>  viewCommiteeMember(@PathVariable int adminId){
		try
		{
			AdmissionCommiteeMemberDto m1=service.viewCommiteeMember(adminId);
			return new ResponseEntity<>(m1,HttpStatus.OK);
		}
		catch(AdmissionMemNotFoundException  e)
		{
			return ResponseEntity.ok().body(e.getMessage());
		}
		}
		@DeleteMapping("/removeCommitee/{adminId}")
		public ResponseEntity<String> removeCommiteeMember(@PathVariable int adminId)
		{
			try
			{
				service.removeCommiteeMember(adminId);
				return ResponseEntity.ok("deleted");
			}
			catch(AdmissionMemNotFoundException e)
			{
				return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
			
		}
		
    
		@GetMapping("/viewAllCommitee")
		public ResponseEntity<List<AdmissionCommiteeMemberDto>>viewCommiteeMembers(){
			List<AdmissionCommiteeMemberDto> lst=service.viewAllCommiteeMembers();
			logger.info("get viewAllCommitee successfully" );
			return new ResponseEntity<>(lst,HttpStatus.OK);
		}
			
		
		@GetMapping("/getAdmissionResult/{applicantId}")
		public ResponseEntity<AdmissionStatus> getAdmissionResult(@PathVariable int applicantId){
			AdmissionStatus status=service.provideAdmissionResult(applicantId);
			return ResponseEntity.ok(status);
		}
		
		}
		
		
				
		