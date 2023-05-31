package com.capg.security.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.entity.UserProfile;
import com.capg.repository.ProfileRepository;

//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	private ProfileRepository profileRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
//      // TODO Auto-generated method stub
//      Optional<UserProfile> userProfile= profileRepository.findByMail(emailId);
//      if(userProfile == null){
//          throw new UsernameNotFoundException(emailId);
//      }else{
//         String username=userProfile.get().getEmailId();
//         String password=userProfile.get().getPassword();
//         return new User(username,password,new ArrayList<>());
//      }
//	}
//}
	

//using role based authorization:
	
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {

        List<SimpleGrantedAuthority> roles = null;
        Optional<UserProfile> userProfile = profileRepository.findByMail(emailId);
        if (userProfile == null) {
            throw new UsernameNotFoundException(emailId);
        }
        else {
                
                if (emailId.equals("admin"))
                {
                    roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
                    return new User("admin", "admin", roles);
                }
                
                else
                {
                    String username = userProfile.get().getEmailId();
                    String password = userProfile.get().getPassword();
                    roles = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
                    return new User(username, password, roles);
                }
        }
    }
}


