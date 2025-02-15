package com.collage.system.common.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collage.system.common.entity.City;
import com.collage.system.common.entity.User;
import com.collage.system.common.model.request.UserSignupRequestModel;
import com.collage.system.common.model.request.UserUpdateRequestModel;
import com.collage.system.common.repo.CityRepo;
import com.collage.system.common.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private CityRepo cityRepo;

	public void signup(UserSignupRequestModel signupRequestModel) throws Exception {
		
		User byEmail=userRepo.findByEmail(signupRequestModel.getEmail());
		if(byEmail!=null) {
			throw new Exception("Email alredy exist");
		}
		
		User byMobileNumber=userRepo.findByMobileNumber(signupRequestModel.getMobileNumber());
		if(byMobileNumber!=null) {
			throw new Exception("MobileNumber alredy exist");
		}
		
		User byId=userRepo.findById(signupRequestModel.getId());
		if(byEmail!=null) {
			throw new Exception("Email alredy exist");
		}
		
		Optional<City> cityOptional = cityRepo.findById(signupRequestModel.getCityId());
		User user = new User();
		user.setFirstName(signupRequestModel.getFirstName());
		user.setLastName(signupRequestModel.getLastName());
		user.setEmail(signupRequestModel.getEmail());
		user.setAddress(signupRequestModel.getAddress());
		user.setCity(cityOptional.get());
		user.setMobileNumber(signupRequestModel.getMobileNumber());
		user.setPassword(signupRequestModel.getPassword());
		user.setDob(signupRequestModel.getDob());
		User saveUser = userRepo.save(user);

	}

	
public void update(UserUpdateRequestModel userUpdateRequestModel) throws Exception {
		
		
	
	
		Optional<City> cityOptional = cityRepo.findById(userUpdateRequestModel.getCityId());
		if(!cityOptional.isPresent()) {
			throw new Exception("City is not avilable");
		}
		User user = new User();
		user.setId(userUpdateRequestModel.getId());
		user.setFirstName(userUpdateRequestModel.getFirstName());
		user.setLastName(userUpdateRequestModel.getLastName());
		user.setEmail(userUpdateRequestModel.getEmail());
		user.setAddress(userUpdateRequestModel.getAddress());
		user.setCity(cityOptional.get());
		user.setMobileNumber(userUpdateRequestModel.getMobileNumber());
		user.setPassword(userUpdateRequestModel.getPassword());
		user.setDob(userUpdateRequestModel.getDob());
		User saveUser = userRepo.save(user);

	}

}
