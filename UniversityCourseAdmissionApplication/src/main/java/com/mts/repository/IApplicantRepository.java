package com.mts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mts.entity.AdmissionStatus;
import com.mts.entity.Applicant;
@Repository
public interface IApplicantRepository extends JpaRepository<Applicant,Integer>{
	
	@Query(value="SELECT status FROM applicant WHERE applicant_id=:n",nativeQuery=true)
	AdmissionStatus getStatusById(@Param("n")int applicantId);
	 List<Applicant>  findByStatus(AdmissionStatus status);
}
