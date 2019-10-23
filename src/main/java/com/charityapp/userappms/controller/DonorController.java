package com.charityapp.userappms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charityapp.userappms.dto.LoginDTO;
import com.charityapp.userappms.model.Donor;
import com.charityapp.userappms.service.DonorService;
import com.charityapp.userappms.util.Message;
import com.charityapp.userappms.util.MessageConstant;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("donor")
public class DonorController {

	@Autowired
	DonorService donorService;

	@PostMapping("login")
	@ApiOperation("Donor Login")
	@ApiResponses(value = { @ApiResponse(code = 200, message = MessageConstant.LOGIN_SUCCESS, response = Donor.class),
			@ApiResponse(code = 400, message = MessageConstant.INVALID_CREDENTIAL, response = Message.class) })
	public ResponseEntity<?> donorLogin(@RequestBody LoginDTO login) {
		Donor donorResponseObj = null;
		Donor donorObj = new Donor();
		donorObj.setEmail(login.getEmail());
		donorObj.setPassword(login.getPassword());
		donorResponseObj = donorService.donorLogin(donorObj);
		if (donorResponseObj != null) {
			return new ResponseEntity<>(donorResponseObj, HttpStatus.OK);
		} else {
			Message message = new Message(MessageConstant.INVALID_CREDENTIAL);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
	}
}
