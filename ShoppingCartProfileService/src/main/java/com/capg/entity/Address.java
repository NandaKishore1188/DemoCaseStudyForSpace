package com.capg.entity;


import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
import com.capg.dto.AddressDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="address")
//@Entity
//@Table(name = "Address")
public class Address {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "primary_key")
//	private Integer pkey;
	
//	@Column(name = "D_No")
	private Integer houseNumber;
	
//	@Column(name = "street")
	private String streetName;
	
//	@Column(name = "colony")
	private String colonyName;
	
//	@Column(name = "city")
	private String city;
	
//	@Column(name = "state")
	private String state;
	
//	@Column(name = "pincode")
	private int pincode;
	
	
	public Address(AddressDTO addressDTO) {
		this.houseNumber = addressDTO.getHouseNumber();
		this.streetName = addressDTO.getStreetName();
		this.colonyName = addressDTO.getColonyName();
		this.city = addressDTO.getCity();
		this.state = addressDTO.getState();
		this.pincode = addressDTO.getPincode();
	}
	
}
