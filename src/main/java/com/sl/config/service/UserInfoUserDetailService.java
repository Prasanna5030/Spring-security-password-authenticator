package com.sl.config.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.sl.entity.UserInfo;
import com.sl.repository.UserInfoRepository;

public class UserInfoUserDetailService implements UserDetailsService {
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo=userInfoRepository.findByUsername(username);
		return 
				userInfo.map( UserInfoUserDetails:: new)
				.orElseThrow(()->new UsernameNotFoundException("user with" + username +" does not exists"));
	}

}
