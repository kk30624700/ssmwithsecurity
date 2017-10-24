package com.boottest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boottest.dao.UserSecurityDao;
import com.boottest.domain.UserSecurity;

@Service
public class UserSecurityServiceImpl implements UserDetailsService{
	@Autowired
	UserSecurityDao userSecurityDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserSecurity user = userSecurityDao.getSecurityInfo(username);
		
		if (null == user) {
			throw new UsernameNotFoundException("User '" + username + "' not found.");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRoleName()));
			
		return new User(user.getUserName(), user.getPassword(), authorities);
	}
}
