package com.udemy.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.udemy.entity.UserRole;
import com.udemy.repository.UserRepository;

//@Service("userServices")
//public class UserServices implements UserDetailsService  {
	public class UserServices  {
//	
//	@Autowired
//	@Qualifier("userRepository")
//	private UserRepository userRepository;
//	
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		com.udemy.entity.User user = userRepository.findByUsername(username);
//		List<GrantedAuthority> authorities = builAuthorities(user.getUserRole());
//		
//		
//		return buildUser(user,authorities);
//	 
//	}
//	
//	
//	
//	/**
//	 * Builds the user.
//	 *
//	 * @param user the user
//	 * @param authorities the authorities
//	 * @return the user
//	 */
//	private User buildUser(com.udemy.entity.User user, List<GrantedAuthority> authorities) //entidad rol
//	{
//		return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
//	}
//	
//	
//	private List<GrantedAuthority> builAuthorities( Set<UserRole> userRole )
//	{
//		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
//		
//		for(UserRole userR : userRole)
//		{
//			auths.add(new SimpleGrantedAuthority(userR.getRole()));
//		}
//		
//		
//		
//		return new ArrayList<GrantedAuthority>(auths);
//	}
//	

}
