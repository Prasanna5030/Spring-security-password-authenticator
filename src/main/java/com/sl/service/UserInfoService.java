package com.sl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sl.entity.UserInfo;
import com.sl.repository.UserInfoRepository;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public  UserInfo  addUser(UserInfo userInfo) {
		String password= passwordEncoder.encode(userInfo.getPassword());
		userInfo.setPassword(password);
		return userInfoRepository.save(userInfo);
	}
	
	public List<UserInfo> getAllUsers(){
		return userInfoRepository.findAll();
		}
}
