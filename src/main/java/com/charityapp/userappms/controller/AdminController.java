package com.charityapp.userappms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.charityapp.userappms.dto.LoginDTO;
import com.charityapp.userappms.model.Admin;
import com.charityapp.userappms.service.AdminService;
import com.charityapp.userappms.util.Message;
import com.charityapp.userappms.util.MessageConstant;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private AdminService adminServiceObj;

	@PostMapping("login")
	@ApiOperation("Admin Login")
	@ApiResponses(value = { @ApiResponse(code = 200, message = MessageConstant.LOGIN_SUCCESS, response = Admin.class),
			@ApiResponse(code = 400, message = MessageConstant.INVALID_CREDENTIAL, response = Message.class) })

	public ResponseEntity<?> adminLogin(@RequestBody LoginDTO login) {
		Admin adminObj = new Admin();
		Admin adminResponseObj = null;
		adminObj.setEmail(login.getEmail());
		adminObj.setPassword(login.getPassword());
		adminResponseObj = adminServiceObj.adminLogin(adminObj);

		if (adminResponseObj != null) {
			return new ResponseEntity<>(adminResponseObj, HttpStatus.OK);
		} else {
			Message message = new Message(MessageConstant.INVALID_CREDENTIAL);
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}

	}

}
