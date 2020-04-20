package com.sms.oAuth_service.service;

import java.util.Optional;

import com.sms.oAuth_service.model.Authuserdetail;
import com.sms.oAuth_service.model.User;
import com.sms.oAuth_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class UserdetailServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

		Optional<User> optionalUser = repo.findByUsername(name);
		
		optionalUser.orElseThrow(() -> new UsernameNotFoundException("username or password error"));
		
		UserDetails userdetails = new Authuserdetail(optionalUser.get());
		
		new AccountStatusUserDetailsChecker().check(userdetails);
		
		return userdetails;
		
	}

}
