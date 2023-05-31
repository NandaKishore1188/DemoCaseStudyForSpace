package com.capg.repository;

import java.util.Optional;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.entity.UserProfile;

@Repository
public interface ProfileRepository extends MongoRepository <UserProfile, Integer> {

	@Query("{ 'emailId' : ?0 }")
	Optional<UserProfile> findByMail(String emailId);
	
}