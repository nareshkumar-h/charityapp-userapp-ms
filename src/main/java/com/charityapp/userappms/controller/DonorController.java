package com.charityapp.userappms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charityapp.userappms.model.Donor;
import com.charityapp.userappms.util.Message;
import com.charityapp.userappms.util.MessageConstatnt;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("donor")
public class DonorController {
//	@PostMapping("login")
//	@ApiOperation("Donor Login")
//	@ApiResponses(value={
//		@ApiResponse(code = 200, message = MessageConstatnt.LOGIN_SUCCESS, response = Donor.class),
//		@ApiResponse(code = 400, message = MessageConstatnt.INVALID_CREDENTIAL, response = Message.class)
//	})
//	public ResponseEntity<?> donorLogin()
//	{
//		String 
//	}
}
