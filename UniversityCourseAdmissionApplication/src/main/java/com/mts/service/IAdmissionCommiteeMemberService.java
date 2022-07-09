package com.mts.service;

import java.util.List;

import com.mts.DTO.AdmissionCommiteeMemberDto;
import com.mts.entity.Admission;
import com.mts.entity.AdmissionCommiteeMember;
import com.mts.entity.AdmissionStatus;
import com.mts.entity.Applicant;
import com.mts.exception.AdmissionMemNotFoundException;

public interface IAdmissionCommiteeMemberService {
	public AdmissionCommiteeMember addCommiteeMember(AdmissionCommiteeMember member);

	public AdmissionCommiteeMember updateCommiteeMember(AdmissionCommiteeMember member)throws AdmissionMemNotFoundException;

	public AdmissionCommiteeMemberDto viewCommiteeMember(int adminId)throws AdmissionMemNotFoundException;

	public void removeCommiteeMember(int adminId)throws AdmissionMemNotFoundException;

	public List<AdmissionCommiteeMemberDto> viewAllCommiteeMembers();

	public AdmissionStatus provideAdmissionResult(int applicantId);
}