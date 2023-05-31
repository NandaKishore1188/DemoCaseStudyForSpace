package com.capg.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dto.UserProfileDTO;
import com.capg.entity.UserProfile;
import com.capg.exception.CustomerNotFoundException;
import com.capg.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileRepository profileRepository;
	
	
	@Override
	public UserProfileDTO addNewCustomerProfile(UserProfileDTO userProfileDTO) {
		// TODO Auto-generated method stub
		UserProfile userProfile = new UserProfile(userProfileDTO);
//        userProfile.setProduct(productInfo.getProductDetails(userProfile.getProductId()));
		return new UserProfileDTO(profileRepository.save(userProfile));	
	}

	@Override
	public List<UserProfileDTO> getAllProfiles() {
		// TODO Auto-generated method stub
		List<UserProfile> userProfile = profileRepository.findAll();
		return userProfile.stream().map(UserProfileDTO::new).collect(Collectors.toList());
	}
	

	@Override
	public UserProfileDTO getByProfileId(Integer profileId) {
		// TODO Auto-generated method stub
		UserProfile userProfile = profileRepository.findById(profileId).orElseThrow(() -> new  CustomerNotFoundException("Customer Does Not Exist With Given Id : "+profileId));
		return new UserProfileDTO(userProfile);
		
	}
	
	//the following code is for the update method in mongoDB
	
	@Override
	public UserProfile updateProfile(UserProfile userProfile) throws Exception {
		Optional<UserProfile> user = this.profileRepository.findById(userProfile.getProfileId());
		if (user.isPresent()) {
			UserProfile userUpdate = user.get();
			userUpdate.setFullName(userProfile.getFullName());
			userUpdate.setEmailId(userProfile.getEmailId());
			userUpdate.setMobileNumber(userProfile.getMobileNumber());
			userUpdate.setGender(userProfile.getGender());
//			userUpdate.setDateOfBirth(userProfile.getDateOfBirth());
//			userUpdate.setAddress(userProfile.getAddress());
			profileRepository.save(userUpdate);
	        return userUpdate;
	    } else {
	        throw new Exception("Record not found with id : " + userProfile.getProfileId());
	    }
	}
	
	

	@Override
	public void deleteUserProfile(Integer profileId) {
		// TODO Auto-generated method stub
		UserProfile userProfile = profileRepository.findById(profileId).orElseThrow(() -> new  CustomerNotFoundException("Customer Does Not Exist With Given Id : "+profileId));;
		profileRepository.delete(userProfile);
		
	}

	

	@Override
	public void deleteAllUserProfiles() {
		// TODO Auto-generated method stub
		profileRepository.deleteAll();
	}

	@Override
	public UserProfileDTO getByMail(String emailId) {
		// TODO Auto-generated method stub
		UserProfile userProfile = profileRepository.findByMail(emailId).orElseThrow(() -> new  CustomerNotFoundException("Customer Does Not Exist With Given Mail : "+emailId));
		
		return new UserProfileDTO(userProfile);
	}

}
	
//	@Override
//	public UserProfileDTO partialupdateUsermail(Integer profileId, String emailId) {
//		// TODO Auto-generated method stub
//		UserProfile userProfile = profileRepository.findById(profileId).orElseThrow(() -> new  CustomerNotFoundException("Customer Does Not Exist With Given Id : "+profileId));
//		userProfile.setEmailId(emailId);
//		return new UserProfileDTO(userProfile);
//	}

	
//@Override
////@Transactional
//public UserProfileDTO updateUserProfile(Integer profileId, UserProfileDTO userProfileDTO) {
//	// TODO Auto-generated method stub
//	UserProfile userProfile = profileRepository.findById(profileId).orElseThrow(() -> new  CustomerNotFoundException("Customer Does Not Exist With Given Id : "+profileId));
//	userProfile.setFullName(userProfileDTO.getFullName());
//	userProfile.setEmailId(userProfileDTO.getEmailId());
//	userProfile.setGender(userProfileDTO.getGender());
//	userProfile.setMobileNumber(userProfileDTO.getMobileNumber());
//	userProfile.setDateOfBirth(userProfileDTO.getDateOfBirth());
//	userProfile.setAddress(userProfileDTO.getAddress());
//	return new UserProfileDTO(userProfile);
//}







	

//
//	@Override
//	public UserProfileDTO partialupdateUserMobileNumber(Integer profileId, double mobileNumber) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	@Override
//	public UserProfileDTO getByMobileNumber(double mobileNumber) {
//		// TODO Auto-generated method stub
//		UserProfile userProfile = profileRepository.findById(mobileNumber)
//	}

	

