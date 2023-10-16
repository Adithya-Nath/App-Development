package com.blooddonation.main.service;



	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.blooddonation.main.model.CampRegistration;
	import com.blooddonation.main.repository.CampRegistrationRepo;

	@Service
	public class CampRegistrationService {
		@Autowired
		CampRegistrationRepo dr;
		public CampRegistration create(CampRegistration CampRegistrations) {
	        return dr.save(CampRegistrations);
	    }

		public List<CampRegistration> getAllCampRegistrationData() {
			return dr.findAll();
		}

	    public CampRegistration update(CampRegistration a) {
	        return dr.save(a);
	    }

	    public void delete(Long id) {
	        dr.deleteById(id);
	    }
	}