package com.blooddonation.main.service;



	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.blooddonation.main.model.Donor;
	import com.blooddonation.main.repository.DonorRepo;

	@Service
	public class DonorService {
		@Autowired
		DonorRepo dr;
		public Donor create(Donor donors) {
	        return dr.save(donors);
	    }

		public List<Donor> getAllDonorData() {
			return dr.findAll();
		}

	    public Donor update(Donor a) {
	        return dr.save(a);
	    }

	    public void delete(Long id) {
	        dr.deleteById(id);
	    }
	}

