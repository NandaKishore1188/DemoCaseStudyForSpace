package com.capg.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;

import com.capg.dto.UserProfileDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
//@Entity
//@Table(name = "users_tbl")
public class UserProfile {

	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";

	@Id
	private Integer profileId;

	private String fullName;

	private String emailId;

//	private String username;

	private String password;

	private long mobileNumber;

//	private LocalDate dateOfBirth;
//
	private String gender;
//
//	private List<Address> address;

	public UserProfile(UserProfileDTO userProfileDTO) {
		this.profileId = userProfileDTO.getProfileId();
		this.fullName = userProfileDTO.getFullName();
		this.emailId = userProfileDTO.getEmailId();
		this.mobileNumber = userProfileDTO.getMobileNumber();
//		this.dateOfBirth = userProfileDTO.getDateOfBirth();
		this.gender = userProfileDTO.getGender();
//		this.address = userProfileDTO.getAddress();
		this.password = userProfileDTO.getPassword();
		
//		this.username=userProfileDTO.getUsername();

	}

}