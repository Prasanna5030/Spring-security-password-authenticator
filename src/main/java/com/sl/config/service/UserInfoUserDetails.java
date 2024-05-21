package com.sl.config.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sl.entity.UserInfo;

public class UserInfoUserDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	private UserInfo userInfo;
	
	public UserInfoUserDetails(UserInfo userInfo) {
		super();
		this.userInfo = userInfo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Arrays.stream(userInfo.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userInfo.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userInfo.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
