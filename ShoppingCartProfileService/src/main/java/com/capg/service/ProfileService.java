package com.capg.service;

import java.util.List;
import java.util.Optional;

import com.capg.dto.UserProfileDTO;
import com.capg.entity.UserProfile;

public interface ProfileService {
	
	UserProfileDTO addNewCustomerProfile(UserProfileDTO userProfileDTO);
	
	List<UserProfileDTO> getAllProfiles();
	
	UserProfileDTO getByProfileId(Integer profileId);
	
	void deleteUserProfile(Integer profileId);
	
	//the following code is for the update method in mongoDB
	UserProfile updateProfile(UserProfile userProfile) throws Exception;
	
	void deleteAllUserProfiles();
	
	UserProfileDTO getByMail(String emailId);
	
//	 public Optional<UserProfile> getByMail(String email);

}

//UserProfileDTO updateUserProfile(Integer profileId, UserProfileDTO userProfileDTO);

//UserProfileDTO partialupdateUsermail(Integer profileId, String emailId);

//UserProfileDTO getByUserMailId(String emailId);

//UserProfileDTO partialupdateCustomerFullName(Integer profileId, String Fullname);

//
//UserProfileDTO partialupdateUserMobileNumber(Integer profileId, double mobileNumber);

//UserProfileDTO getByMobileNumber(double mobileNumber);





