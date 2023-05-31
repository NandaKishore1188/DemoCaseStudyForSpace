package com.capg.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.capg.entity.Address;
import com.capg.entity.UserProfile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileDTO {

	
	private Integer profileId;

//	@NotBlank(message="User Name Can't Be Blank!!")
//	@Size(min = 1,max = 100)
	private String fullName;

//	@NotBlank(message="User Mail Can't Be Blank or Null!!")
//	@Size(min = 5,max = 100)
//	@Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
//	@Indexed(unique=true)
	private String emailId;
	
	
//	private String username;

	private String password;
	
	private long mobileNumber;
		
//	private LocalDate dateOfBirth;
//		
	private String gender;
//	
//	private List<Address> address;
//	


	public UserProfileDTO(UserProfile userProfile) {
		this.profileId=userProfile.getProfileId();
		this.fullName=userProfile.getFullName();
		this.emailId=userProfile.getEmailId();
		this.mobileNumber=userProfile.getMobileNumber();
//		this.dateOfBirth=userProfile.getDateOfBirth();
		this.gender=userProfile.getGender();
//		this.address=userProfile.getAddress();
		this.password=userProfile.getPassword();
		
//		this.username=userProfile.getUsername();
		
//		this.productId = userProfile.getProductId();
//        this.product = userProfile.getProduct();
	}

}
