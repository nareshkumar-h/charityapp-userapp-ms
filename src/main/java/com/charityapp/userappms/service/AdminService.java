package com.charityapp.userappms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charityapp.userappms.model.Admin;
import com.charityapp.userappms.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepoObj;
	public Admin adminLogin(final Admin adminObj)
	{
		Admin adminResponseObj = null;
		String email = adminObj.getEmail();
		String password = adminObj.getPassword();
		adminResponseObj = adminRepoObj.findByEmailAndPassword(email, password);
		return adminResponseObj;
	}
	public Admin adminRegister(final Admin adminObj)
	{
		Admin adminResponseObj = null;
		adminResponseObj = adminRepoObj.save(adminObj);
		return adminResponseObj;
	}
}
