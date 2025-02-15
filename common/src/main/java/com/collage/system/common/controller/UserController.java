package com.collage.system.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.collage.system.common.model.request.UserSignupRequestModel;
import com.collage.system.common.model.request.UserUpdateRequestModel;
import com.collage.system.common.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("UserController: Object Created");
	}

	@RequestMapping(method = RequestMethod.POST, value = "/signup", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> signup(@RequestBody UserSignupRequestModel signupRequestModel) {
		System.out.println("saving user data with email:" + signupRequestModel.getEmail());
		try {
			userService.signup(signupRequestModel);
			return new ResponseEntity<Object>("Data", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Failed to save user due to :" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@RequestMapping(method = RequestMethod.POST, value = "/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> update(@RequestBody UserUpdateRequestModel userUpdateRequestModel) {
		System.out.println("saving user data with email:" + userUpdateRequestModel.getEmail());
		try {
			userService.update(userUpdateRequestModel);
			return new ResponseEntity<Object>("update", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Failed to update user due to :" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/Login", consumes = "application/json", produces = "application/json")
	public void Login() {
		System.out.println("Login");
		

	}

	@RequestMapping(method = RequestMethod.GET, value = "/findById", produces = "application/json")
	public void findById() {
		System.out.println("findById");

	}

	@RequestMapping(method = RequestMethod.GET, value = "/findAll", produces = "application/json")
	public void findAll() {
		System.out.println("findAll");

	}
}