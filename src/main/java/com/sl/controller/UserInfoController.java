package com.sl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sl.entity.UserInfo;
import com.sl.service.UserInfoService;

import lombok.Getter;

@RestController
@RequestMapping("/api/user")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;
	
	@PostMapping("/add")
	public ResponseEntity<UserInfo> addUser(@RequestBody UserInfo userInfo){
		UserInfo user=userInfoService.addUser(userInfo);
		return new ResponseEntity<UserInfo>(user, HttpStatus.ACCEPTED);
	}
	
		@GetMapping("/all")
		public ResponseEntity<List<UserInfo>> getAllUsers(){
			List<UserInfo> allUsers = userInfoService.getAllUsers();
		return new  ResponseEntity<List<UserInfo>>(allUsers,HttpStatus.OK);
		}
	}

