package com.blooddonation.main.service;



	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

	import com.blooddonation.main.model.Recepient;
	import com.blooddonation.main.repository.RecepientRepo;

	@Service
	public class RecepientService {
		@Autowired
		RecepientRepo dr;
		public Recepient create(Recepient Recepients) {
	        return dr.save(Recepients);
	    }

		public List<Recepient> getAllRecepientData() {
			return dr.findAll();
		}

	    public Recepient update(Recepient a) {
	        return dr.save(a);
	    }

	    public void delete(Long id) {
	        dr.deleteById(id);
	    }
	}