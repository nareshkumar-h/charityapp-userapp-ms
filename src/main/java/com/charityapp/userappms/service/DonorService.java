package com.charityapp.userappms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charityapp.userappms.model.Donor;
import com.charityapp.userappms.repository.DonorRepository;

@Service
public class DonorService {

	@Autowired
	private DonorRepository donorRepoObj;

	public Donor donorLogin(final Donor donorObj) {
		Donor donorResponseObj = null;
		String email = donorObj.getEmail();
		String password = donorObj.getPassword();
		donorResponseObj = donorRepoObj.findByEmailAndPassword(email, password);
		return donorResponseObj;
	}

	public Donor donorRegister(final Donor donorObj) {
		Donor donorResponseObj = null;
		donorResponseObj = donorRepoObj.save(donorObj);
		return donorResponseObj;
	}
}
